package io.horizon.market.instrument;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.slf4j.Logger;

import io.horizon.market.instrument.spec.ChinaFutures;
import io.horizon.market.instrument.spec.ChinaFuturesSymbol;
import io.mercury.common.collections.MutableMaps;
import io.mercury.common.log.CommonLoggerFactory;
import io.mercury.common.util.Assertor;
import io.mercury.serialization.json.JsonWrapper;

/**
 * 
 * 管理全局Instrument状态
 * 
 * @author yellow013
 *
 */
@ThreadSafe
public final class InstrumentKeeper {

	/**
	 * Logger
	 */
	private static final Logger log = CommonLoggerFactory.getLogger(InstrumentKeeper.class);

	// 存储instrument, 以instrumentId索引
	private static final MutableIntObjectMap<Instrument> InstrumentMapById = MutableMaps.newIntObjectHashMap();

	// 存储instrument, 以instrumentCode索引
	private static final MutableMap<String, Instrument> InstrumentMapByCode = MutableMaps.newUnifiedMap();

	private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

	private static ImmutableList<Instrument> instruments;

	private InstrumentKeeper() {
	}

	/**
	 * 
	 * @param instruments
	 */
	public static void initialize(@Nonnull final Instrument... instruments) {
		if (isInitialized.compareAndSet(false, true)) {
			try {
				Assertor.requiredLength(instruments, 1, "instruments");
				Stream.of(instruments).forEach(InstrumentKeeper::putInstrument);
				InstrumentKeeper.instruments = InstrumentMapById.toList().toImmutable();
			} catch (Exception e) {
				RuntimeException re = new RuntimeException("InstrumentManager initialization failed", e);
				log.error("InstrumentManager initialization failed", re);
				throw re;
			}
		} else {
			IllegalStateException e = new IllegalStateException(
					"InstrumentManager Has been initialized, cannot be initialize again");
			log.error("InstrumentManager already initialized", e);
			throw e;
		}
	}

	private static void putInstrument(Instrument instrument) {
		log.info("Put instrument, instrumentId==[{}], instrumentCode==[{}], instrument -> {}",
				instrument.getInstrumentId(), instrument.getInstrumentCode(), instrument);
		InstrumentMapById.put(instrument.getInstrumentId(), instrument);
		InstrumentMapByCode.put(instrument.getInstrumentCode(), instrument);
		setTradable(instrument);
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isInitialized() {
		return isInitialized.get();
	}

	/**
	 * 
	 * @param instrument
	 * @return
	 */
	public static Instrument setTradable(Instrument instrument) {
		return setTradable(instrument.getInstrumentId());
	}

	/**
	 * 
	 * @param instrumentId
	 * @return
	 */
	public static Instrument setTradable(int instrumentId) {
		Instrument instrument = getInstrument(instrumentId);
		instrument.enable();
		log.info("Instrument enable, instrumentId==[{}], instrument -> {}", instrumentId, instrument);
		return instrument;
	}

	/**
	 * 
	 * @param instrument
	 * @return
	 */
	public static Instrument setNotTradable(Instrument instrument) {
		return setNotTradable(instrument.getInstrumentId());
	}

	/**
	 * 
	 * @param instrumentId
	 * @return
	 */
	public static Instrument setNotTradable(int instrumentId) {
		Instrument instrument = getInstrument(instrumentId);
		instrument.disable();
		log.info("Instrument disable, instrumentId==[{}], instrument -> {}", instrumentId, instrument);
		return instrument;
	}

	/**
	 * 
	 * @param instrument
	 * @return
	 */
	public static boolean isTradable(Instrument instrument) {
		return isTradable(instrument.getInstrumentId());
	}

	/**
	 * 
	 * @param instrumentId
	 * @return
	 */
	public static boolean isTradable(int instrumentId) {
		return getInstrument(instrumentId).isEnabled();
	}

	/**
	 * 
	 * @return ImmutableList
	 */
	public static ImmutableList<Instrument> getInstruments() {
		return instruments;
	}

	/**
	 * 
	 * @param instrumentId
	 * @return
	 */
	public static Instrument getInstrument(int instrumentId) {
		Instrument instrument = InstrumentMapById.get(instrumentId);
		if (instrument == null)
			throw new IllegalArgumentException("Instrument is not find, by instrumentId : " + instrumentId);
		return instrument;
	}

	/**
	 * 
	 * @param instrumentId
	 * @return
	 */
	public static Instrument[] getInstrument(int... instrumentIds) {
		Assertor.requiredLength(instrumentIds, 1, "instrumentIds");
		Instrument[] instruments = new Instrument[instrumentIds.length];
		for (int i = 0; i < instrumentIds.length; i++) {
			instruments[i] = getInstrument(instrumentIds[i]);
		}
		return instruments;
	}

	/**
	 * 
	 * @param instrumentCodes
	 * @return
	 */
	public static Instrument[] getInstrument(String... instrumentCodes) {
		Assertor.requiredLength(instrumentCodes, 1, "instrumentCodes");
		Instrument[] instruments = new Instrument[instrumentCodes.length];
		for (int i = 0; i < instrumentCodes.length; i++) {
			instruments[i] = getInstrument(instrumentCodes[i]);
		}
		return instruments;
	}

	/**
	 * 
	 * @param instrumentCode
	 * @return
	 */
	public static Instrument getInstrument(String instrumentCode) {
		Instrument instrument = InstrumentMapByCode.get(instrumentCode);
		if (instrument == null)
			throw new IllegalArgumentException("Instrument is not find, by instrumentCode : " + instrumentCode);
		return instrument;
	}

	public static String showStatus() {
		Map<String, Object> map = new HashMap<>();
		map.put("isInitialized", isInitialized);
		map.put("instruments", getInstruments());
		return JsonWrapper.toPrettyJson(map);
	}

	public static void main(String[] args) {
		ChinaFutures au2012 = new ChinaFutures(ChinaFuturesSymbol.AU, 2012, "2012");
		ChinaFutures rb2101 = new ChinaFutures(ChinaFuturesSymbol.RB, 2101, "2101");
		InstrumentKeeper.initialize(au2012, rb2101);
		System.out.println(InstrumentKeeper.showStatus());
		InstrumentKeeper.setNotTradable(rb2101);
		System.out.println(InstrumentKeeper.showStatus());
	}

}
