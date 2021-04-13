/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy;

/**
 * @author yangdw
 * @version OrderServiceImpl.java, v 0.1 2021-04-07 18:45
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Object createOrder() {
        System.err.println("订单下单逻辑");
        return new Object();
    }

    @Override
    public Object queryOrder() {
        System.err.println("订单查询逻辑");
        return new Object();
    }
}