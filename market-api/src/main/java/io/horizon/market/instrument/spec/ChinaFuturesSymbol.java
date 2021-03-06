package io.horizon.market.instrument.spec;

import static io.mercury.common.collections.ImmutableMaps.immutableIntObjectMapFactory;
import static io.mercury.common.collections.ImmutableMaps.immutableMapFactory;
import static io.mercury.common.collections.ImmutableSets.newImmutableSortedSet;
import static io.mercury.common.collections.MutableLists.newFastList;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.horizon.market.instrument.Exchange;
import io.horizon.market.instrument.Instrument;
import io.horizon.market.instrument.Instrument.PriorityCloseType;
import io.horizon.market.instrument.InstrumentType;
import io.horizon.market.instrument.PriceMultiplier;
import io.horizon.market.instrument.Symbol;
import io.horizon.market.serial.TradablePeriodSerial;
import io.mercury.common.collections.MutableLists;
import io.mercury.serialization.json.JsonWrapper;
import lombok.Getter;

public enum ChinaFuturesSymbol implements Symbol {

	// ************************上海期货交易所************************//
	/**
	 * 铜 cu
	 */
	CU(Exchange.SHFE.genSymbolId(1), "cu", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 铜期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	/**
	 * 铝 al
	 */
	AL(Exchange.SHFE.genSymbolId(2), "al", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 铝期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	/**
	 * 锌 zn
	 */
	ZN(Exchange.SHFE.genSymbolId(3), "zn", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 锌期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	/**
	 * 镍
	 */
	NI(Exchange.SHFE.genSymbolId(4), "ni", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 镍期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	/**
	 * 黄金
	 */
	AU(Exchange.SHFE.genSymbolId(5), "au", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.MULTIPLIER_10000,
			// 黄金期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(2, 30, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"06", "12"),

	/**
	 * 白银
	 */
	AG(Exchange.SHFE.genSymbolId(6), "ag", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 白银期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(2, 30, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"06", "12"),

	/**
	 * 螺纹钢
	 */
	RB(Exchange.SHFE.genSymbolId(7), "rb", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 螺纹钢期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "10"),

	/**
	 * 热卷扎板
	 */
	HC(Exchange.SHFE.genSymbolId(8), "hc", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 热卷扎板期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "10"),

	/**
	 * 橡胶
	 */
	RU(Exchange.SHFE.genSymbolId(9), "ru", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 橡胶期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 燃油
	 */
	FU(Exchange.SHFE.genSymbolId(10), "fu", Exchange.SHFE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 燃油期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	// ************************上海能源交易所************************//
	/**
	 * 原油
	 */
	SC(Exchange.SHINE.genSymbolId(1), "sc", Exchange.SHINE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 原油期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	// **************************大连商品交易所*************************//
	/**
	 * 大豆 a
	 */
	A(Exchange.DCE.genSymbolId(1), "a", Exchange.DCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 大豆期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 豆粕 m
	 */
	M(Exchange.DCE.genSymbolId(2), "m", Exchange.DCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 豆粕期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 豆油 y
	 */
	Y(Exchange.DCE.genSymbolId(3), "y", Exchange.DCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 豆油期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 棕榈油 p
	 */
	P(Exchange.DCE.genSymbolId(4), "p", Exchange.DCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 棕榈油期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 玉米 p
	 */
	C(Exchange.DCE.genSymbolId(4), "c", Exchange.DCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 棕榈油期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 铁矿石 i
	 */
	I(Exchange.DCE.genSymbolId(5), "i", Exchange.DCE, PriorityCloseType.NONE, PriceMultiplier.MULTIPLIER_100,
			// 铁矿石期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),
	// TODO 大商所品种 : 塑料, PVC, PP,

	// *****************************郑州商品交易所***********************************//
	/**
	 * 棉花 cf
	 */
	CF(Exchange.ZCE.genSymbolId(1), "CF", Exchange.ZCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 棉花交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 白糖 sr
	 */
	SR(Exchange.ZCE.genSymbolId(2), "SR", Exchange.ZCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 白糖交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(15, 15, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * PTA
	 */
	TA(Exchange.ZCE.genSymbolId(3), "TA", Exchange.ZCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// PTA交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(15, 15, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 乙醇
	 */
	MA(Exchange.ZCE.genSymbolId(4), "MA", Exchange.ZCE, PriorityCloseType.NONE, PriceMultiplier.NONE,

			// 乙醇交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(15, 15, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	/**
	 * 菜粕
	 */
	RM(Exchange.ZCE.genSymbolId(5), "RM", Exchange.ZCE, PriorityCloseType.NONE, PriceMultiplier.NONE,
			// 菜粕交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
					new TradablePeriodSerial(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
					new TradablePeriodSerial(2, LocalTime.of(10, 30, 00), LocalTime.of(15, 15, 00))),
			// 主力合约月份代码
			"01", "05", "09"),

	// ************************中国金融交易所************************//
	/**
	 * 沪深300期货
	 */
	IF(Exchange.CFFEX.genSymbolId(1), "IF", Exchange.CFFEX, PriorityCloseType.NONE, PriceMultiplier.MULTIPLIER_100,
			// 主力合约月份代码
			// 股指期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(9, 15, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(1, LocalTime.of(13, 00, 00), LocalTime.of(15, 15, 00))),
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	/**
	 * 上证50期货
	 */
	IH(Exchange.CFFEX.genSymbolId(2), "IH", Exchange.CFFEX, PriorityCloseType.NONE, PriceMultiplier.MULTIPLIER_100,
			// 股指期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(9, 15, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(1, LocalTime.of(13, 00, 00), LocalTime.of(15, 15, 00))),
			// 主力合约月份代码
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	/**
	 * 中证500期货
	 */
	IC(Exchange.CFFEX.genSymbolId(3), "IC", Exchange.CFFEX, PriorityCloseType.NONE, PriceMultiplier.MULTIPLIER_100,
			// 股指期货交易时段
			newImmutableSortedSet(new TradablePeriodSerial(0, LocalTime.of(9, 15, 00), LocalTime.of(11, 30, 00)),
					new TradablePeriodSerial(1, LocalTime.of(13, 00, 00), LocalTime.of(15, 15, 00))),
			// 主力合约月份代码
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"),

	;

	// SymbolId
	@Getter
	private final int symbolId;

	// Symbol代码
	@Getter
	private final String symbolCode;

	// 交易所
	@Getter
	private final Exchange exchange;

	// 优先平仓类型
	@Getter
	private final PriorityCloseType priorityCloseType;

	// 价格乘数
	@Getter
	private final PriceMultiplier priceMultiplier;

	// Symbol包含的主力合约列表
	@Getter
	private final ImmutableList<Instrument> instruments;

	// 交易时间段
	@Getter
	private final ImmutableSortedSet<TradablePeriodSerial> tradablePeriodSet;

	// symbolId -> symbol映射
	private final static ImmutableIntObjectMap<ChinaFuturesSymbol> SymbolIdMap = immutableIntObjectMapFactory().from(
			// 将ChinaFuturesSymbol转换为List
			newFastList(ChinaFuturesSymbol.values()),
			// 取symbolId为Key
			ChinaFuturesSymbol::getSymbolId, symbol -> symbol);

	// symbolCode -> symbol的映射
	private final static ImmutableMap<String, ChinaFuturesSymbol> SymbolCodeMap = immutableMapFactory().ofMap(
			// 将ChinaFuturesSymbol转换为List, 再转换为Map
			newFastList(ChinaFuturesSymbol.values()).toMap(
					// 取symbolCode为Key
					ChinaFuturesSymbol::getSymbolCode, symbol -> symbol));

	/**
	 * 
	 * @param symbolId
	 * @param symbolCode
	 * @param exchange
	 * @param priorityCloseType
	 * @param priceMultiplier
	 * @param termMonths
	 * @param tradingPeriods
	 */
	private ChinaFuturesSymbol(int symbolId, String symbolCode, Exchange exchange, PriorityCloseType priorityCloseType,
			PriceMultiplier priceMultiplier, ImmutableSortedSet<TradablePeriodSerial> tradablePeriodSet,
			String... termMonths) {
		this.symbolId = symbolId;
		this.symbolCode = symbolCode;
		this.exchange = exchange;
		this.priorityCloseType = priorityCloseType;
		this.priceMultiplier = priceMultiplier;
		this.instruments = genInstruments(termMonths);

		this.tradablePeriodSet = tradablePeriodSet;
	}

	/**
	 * 以主力合约月份构建合约列表
	 * 
	 * @param termMonths
	 * @return
	 */
	private ImmutableList<Instrument> genInstruments(String[] termMonths) {
		MutableList<Instrument> instruments = MutableLists.newFastList();
		LocalDate now = LocalDate.now(getZoneOffset());
		int thisYear = (now.getYear() % 100);
		int nextYear = (now.plusYears(1).getYear() % 100);
		for (String termMonth : termMonths) {
			int month = Integer.parseInt(termMonth);
			int term0 = thisYear * 100 + month;
			int term1 = nextYear * 100 + month;
			String code0;
			String code1;
			// 对郑商所合约代码特殊处理
			if (exchange == Exchange.ZCE) {
				code0 = String.valueOf(thisYear % 10) + termMonth;
				code1 = String.valueOf(nextYear % 10) + termMonth;
			} else {
				code0 = String.valueOf(term0);
				code1 = String.valueOf(term1);
			}
			instruments.add(new ChinaFutures(this, term0, code0));
			instruments.add(new ChinaFutures(this, term1, code1));
		}
		return instruments.toImmutable();
	}

	@Override
	public InstrumentType getType() {
		return InstrumentType.FUTURES;
	}

	/**
	 * 
	 * @param symbolId
	 * @return
	 */
	public static ChinaFuturesSymbol of(int symbolId) {
		ChinaFuturesSymbol symbol = SymbolIdMap.get(symbolId);
		if (symbol == null)
			throw new IllegalArgumentException("symbolId -> " + symbolId + " is not mapping object");
		return symbol;
	}

	/**
	 * 
	 * @param symbolCode
	 * @return
	 */
	public static ChinaFuturesSymbol of(String symbolCode) {
		ChinaFuturesSymbol symbol = SymbolCodeMap.get(symbolCode);
		if (symbol == null) {
			symbol = SymbolCodeMap.get(symbolCode.toUpperCase());
			if (symbol == null)
				throw new IllegalArgumentException("symbolCode -> " + symbolCode + " is not mapping object");
		}
		return symbol;
	}

	/**
	 * 
	 * @param term
	 * @return
	 */
	public int acquireInstrumentId(int term) {
		if (term > 9999)
			throw new IllegalArgumentException("Term > 9999, Is too much.");
		return symbolId + term;
	}

	private String formatText;

	@Override
	public String format() {
		if (formatText == null) {
			Map<String, Object> tempMap = new HashMap<>();
			tempMap.put("exchangeCode", getExchangeCode());
			tempMap.put("symbolId", symbolId);
			tempMap.put("symbolCode", symbolCode);
			tempMap.put("priorityCloseType", priorityCloseType);
			tempMap.put("priceMultiplier", priceMultiplier);
			this.formatText = JsonWrapper.toJson(tempMap);
		}
		return formatText;
	}

	@Override
	public String toString() {
		return format();
	}

	public static void main(String[] args) {
		for (Symbol symbol : ChinaFuturesSymbol.values()) {
			symbol.getTradablePeriodSet()
					.each(tradingPeriod -> tradingPeriod.segmentation(symbol.getZoneOffset(), Duration.ofSeconds(30))
							.each(timePeriod -> System.out.println(symbol.getSymbolCode() + " | " + timePeriod)));

			symbol.getTradablePeriodSet().stream()
					.map(tradingPeriod -> tradingPeriod.segmentation(symbol.getZoneOffset(), Duration.ofSeconds(30)));
		}
		System.out.println(ChinaFuturesSymbol.AG.format());
		System.out.println(ChinaFuturesSymbol.AG.getExchange().getExchangeId());
		System.out.println(ChinaFuturesSymbol.AG.getSymbolId());

		for (ChinaFuturesSymbol symbol : ChinaFuturesSymbol.values()) {
			symbol.getInstruments().each(instrument -> System.out.println(instrument.format()));
		}

	}

	@Override
	public int getTickSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
