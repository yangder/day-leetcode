/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理要求target对象是一个接口的实现对象，假如target对象只是一个单独的对象，并没有实现任何接口，
 * 这时候就会用到Cglib代理(Code Generation Library)，即通过构建一个子类对象，从而实现对target对象的代理
 * @author yangdw
 * @version OrderServiceDynamicProxy.java, v 0.1 2021-04-13 15:41
 */
public class OrderServiceDynamicProxy<T> {

    // 被代理对象
    private T target;

    private OrderServiceInvocation invocation;

    public OrderServiceDynamicProxy(T target, OrderServiceInvocation invocation) {
        this.target = target;
        this.invocation = invocation;
    }

    /**
     * ClassLoader loader：指定当前target对象使用类加载器，获取加载器的方法是固定的；
     * Class<?>[] interfaces：target对象实现的接口的类型，使用泛型方式确认类型
     * InvocationHandler invocationHandler:事件处理,执行target对象的方法时，会触发事件处理器的方法，会把当前执行target对象的方法作为参数传入。
     *
     * @return
     */
    public Object getProxyTarget() {
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocation);
        return proxyInstance;
    }
}