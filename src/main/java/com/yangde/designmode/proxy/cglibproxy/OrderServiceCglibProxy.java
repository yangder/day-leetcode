/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JDK动态代理需要被代理类是一个接口的实现类
 * 如果一个类是一个单独的对象,并没有实现任何接口,可以用cglib代理,即构造一个子类对象,从而实现对target对象的代理
 *
 * @author yangdw
 * @version OrderServiceCglibProxy.java, v 0.1 2021-04-13 17:46
 */
public class OrderServiceCglibProxy<T> implements MethodInterceptor {

    private T target;

    public OrderServiceCglibProxy(T target) {
        this.target = target;
    }

    /**
     * 给被代理对象创建一个代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        // 工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类代理对象
        Object obj = enhancer.create();
        return obj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("判断是否有权限操作");
        Object obj = method.invoke(target, objects);
        System.err.println("打印用户操作后流程");
        return obj;
    }
}