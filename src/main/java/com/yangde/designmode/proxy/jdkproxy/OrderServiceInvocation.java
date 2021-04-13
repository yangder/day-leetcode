/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yangdw
 * @version OrderServiceInvocation.java, v 0.1 2021-04-13 15:27
 */
public class OrderServiceInvocation implements InvocationHandler {

    // 被代理类
    private Object target;

    public OrderServiceInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("判断用户是否有权限操作");
        Object obj = method.invoke(target, args);
        System.err.println("打印返回值,操作后日志");
        return obj;
    }
}