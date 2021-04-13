/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy.cglibproxy;

/**
 * @author yangdw
 * @version CglibProxyTest.java, v 0.1 2021-04-13 22:23
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        OrderServiceCglib target = new OrderServiceCglib();

        OrderServiceCglibProxy cglibProxy = new OrderServiceCglibProxy(target);
        OrderServiceCglib proxy = (OrderServiceCglib) cglibProxy.getProxyInstance();

        System.err.println("代理对象:" + proxy.getClass());
        System.err.println("前置方法增强");
        Object order = proxy.createOrder();
        System.err.println("------------");
        Object queryOrder = proxy.queryOrder();
        System.err.println("后置方法增强");
    }

}   