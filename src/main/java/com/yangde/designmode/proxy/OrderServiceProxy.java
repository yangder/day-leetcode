/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy;

/**
 * @author yangdw
 * @version OrderServiceProxy.java, v 0.1 2021-04-07 18:53
 */
public class OrderServiceProxy implements OrderService {

    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Object createOrder() {

        System.err.println("打印日志 and 校验是否有下单权限");
        // 下单操作
        return orderService.createOrder();
    }

    @Override
    public Object queryOrder() {
        System.err.println("打印日志 and 校验是否有查询权限");
        // 查询操作
        return orderService.queryOrder();
    }
}