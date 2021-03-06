package io.horizon.ftdc.adaptor;

import javax.annotation.Nonnull;

import io.horizon.ftdc.adaptor.consts.FtdcDirection;
import io.horizon.ftdc.adaptor.consts.FtdcOffsetFlag;
import io.horizon.ftdc.adaptor.consts.FtdcOrderStatusType;
import io.horizon.trader.order.attr.OrdStatus;
import io.horizon.trader.order.attr.TrdAction;
import io.horizon.trader.order.attr.TrdDirection;

public final class FtdcConstMapper {

	/**
	 * 根据<b> [FTDC返回] </b>订单状态, 映射<b> [系统自定义] </b>订单状态
	 * 
	 * @param orderStatus
	 * @return
	 */
	@Nonnull
	public static final OrdStatus fromOrderStatus(char orderStatus) {
		return
		// 未成交不在队列中 or 未成交还在队列中 return [OrdStatus.New]
		FtdcOrderStatusType.NoTradeNotQueueing == orderStatus || FtdcOrderStatusType.NoTradeQueueing == orderStatus
				? OrdStatus.New
				// 部分成交不在队列中 or 部分成交还在队列中 return [OrdStatus.PartiallyFilled]
				: FtdcOrderStatusType.PartTradedNotQueueing == orderStatus
						|| FtdcOrderStatusType.PartTradedQueueing == orderStatus ? OrdStatus.PartiallyFilled
								// 全部成交 return [OrdStatus.Filled]
								: FtdcOrderStatusType.AllTraded == orderStatus ? OrdStatus.Filled
										// 撤单 return [OrdStatus.Canceled]
										: FtdcOrderStatusType.Canceled == orderStatus ? OrdStatus.Canceled
												// return [OrdStatus.Invalid]
												: OrdStatus.Invalid;
	}

	/**
	 * 根据<b>[FTDC返回]</b>开平仓类型, 映射<b>[系统自定义]</b>开平仓类型
	 * 
	 * @param combOffsetFlag
	 * @return
	 */
	@Nonnull
	public static final TrdAction fromOffsetFlag(@Nonnull String combOffsetFlag) {
		return fromOffsetFlag(combOffsetFlag.charAt(0));
	}

	/**
	 * 根据<b>[FTDC返回]</b>开平仓类型, 映射<b>[系统自定义]</b>开平仓类型
	 * 
	 * @param offsetFlag
	 * @return
	 */
	@Nonnull
	public static final TrdAction fromOffsetFlag(char offsetFlag) {
		return
		// 开仓
		FtdcOffsetFlag.Open == offsetFlag ? TrdAction.Open
				// 平仓
				: FtdcOffsetFlag.Close == offsetFlag ? TrdAction.Close
						// 平今
						: FtdcOffsetFlag.CloseToday == offsetFlag ? TrdAction.CloseToday
								// 平昨
								: FtdcOffsetFlag.CloseYesterday == offsetFlag ? TrdAction.CloseYesterday
										// 未知
										: TrdAction.Invalid;
	}

	/**
	 * 根据<b>[FTDC返回]</b>买卖方向类型, 映射<b>[系统自定义]</b>买卖方向类型类型
	 * 
	 * @param direction
	 * @return
	 */
	public static final TrdDirection fromDirection(char direction) {
		return
		// 买
		FtdcDirection.Buy == direction ? TrdDirection.Long
				// 卖
				: FtdcDirection.Sell == direction ? TrdDirection.Short
						// 未知
						: TrdDirection.Invalid;
	}

}
