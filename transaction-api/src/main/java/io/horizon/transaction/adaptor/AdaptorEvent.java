package io.horizon.transaction.adaptor;

import io.horizon.transaction.event.ControlEvent;
import io.mercury.serialization.json.JsonWrapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class AdaptorEvent implements ControlEvent {

	/**
	 * adaptorId
	 */
	@Getter
	private final String adaptorId;

	/**
	 * status
	 */
	@Getter
	private final AdaptorStatus status;

	@Override
	public int getCode() {
		return status.code;
	}

	private String toStringCache;

	@Override
	public String toString() {
		return (toStringCache == null) ? toStringCache = JsonWrapper.toJson(this) : toStringCache;
	}

	/**
	 * 
	 * @author yellow013
	 *
	 */
	@RequiredArgsConstructor
	public static enum AdaptorStatus {

		MdEnable(10),

		MdDisable(11),

		TraderEnable(12),

		TraderDisable(13),

		;

		@Getter
		private final int code;

	}

}