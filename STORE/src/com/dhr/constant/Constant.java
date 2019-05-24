package com.dhr.constant;
/**
 * 保存常用常量
 * @author Mr DU
 *
 */
public interface Constant {
	/**
	 * 记住用户名
	 */
	String SAVE_NAME = "ok";
	/**
	 * 是否热门
	 */
	Integer IS_HOT = 1;
	/**
	 * 是否下架 0未下架
	 */
	Integer IS_FLAG = 0;
	/**
	 * 热门显示条数
	 */
	Integer COUNT = 9;
	/**
	 * 最新条数
	 */
	Integer IS_NEW = 15;
	/**
	 * 喜欢
	 */
	Integer IS_LIKE = 35;
	/**
	 * 订单状态  0未付款 1已付款 2已发货 3已完成
	 */
	Integer ORDER_NO = 0;
	Integer ORDER_YES = 1;
	Integer ORDER_OK  =2;
	Integer ORDER_SUCCESS = 3;
}
