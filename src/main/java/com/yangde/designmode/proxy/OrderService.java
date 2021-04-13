/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy;

/**
 * @author yangdw
 * @version OrderService.java, v 0.1 2021-04-07 18:43
 */
public interface OrderService {

    /**
     * 下单
     */
    Object createOrder();

    /**
     * 查询订单
     */
    Object queryOrder();
}
