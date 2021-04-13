/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy;

/**
 * @author yangdw
 * @version ProxyTest.java, v 0.1 2021-04-07 19:33
 */
public class ProxyTest {
    // https://www.jianshu.com/p/8ccdbe00ff06
    public static void main(String[] args) {

        OrderServiceProxy proxy = new OrderServiceProxy(new OrderServiceImpl());
        proxy.createOrder();
        System.err.println("============");
        proxy.queryOrder();
    }

}   