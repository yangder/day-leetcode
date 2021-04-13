/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.designmode.proxy.jdkproxy;

import com.yangde.designmode.proxy.OrderService;
import com.yangde.designmode.proxy.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yangdw
 * @version JdkProxyTest.java, v 0.1 2021-04-13 16:08
 */
public class JdkProxyTest {

    public static void main(String[] args) {
//        OrderServiceDynamicProxy proxy = new OrderServiceDynamicProxy();

        // 方法一
        System.out.println("============ 方法一 ==============");
        OrderService target1 = new OrderServiceImpl();
        System.out.println("被代理对象：" + target1.getClass());

        OrderServiceInvocation orderServiceInvocation = new OrderServiceInvocation(target1);
        OrderService proxy = (OrderService) new OrderServiceDynamicProxy(target1, orderServiceInvocation).getProxyTarget();
        System.out.println("代理对象1：" + proxy.getClass());
        Object obj = proxy.createOrder();
        System.out.println("createOrder1 返回对象：" + obj.getClass());
        System.out.println("----------------------------------");
        proxy.queryOrder();

        //方法二
        System.out.println("============ 方法二 ==============");
        OrderService target2 = new OrderServiceImpl();
        OrderServiceInvocation invocation = new OrderServiceInvocation(target2);
        OrderService proxy2 = (OrderService) Proxy.newProxyInstance(target2.getClass().getClassLoader(), target2.getClass().getInterfaces(), invocation);
        System.out.println("代理对象2：" + proxy2.getClass());
        Object obj2 = proxy2.createOrder();
        System.out.println("createOrder2 返回对象：" + obj2.getClass());
        System.out.println("----------------------------------");
        proxy2.queryOrder();

        //方法三
        System.out.println("============ 方法三 ==============");
        final OrderService target3 = new OrderServiceImpl();
        OrderService proxy3 = (OrderService) Proxy.newProxyInstance(target3.getClass().getClassLoader(), target3.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("判断用户是否有权限进行操作");
                Object obj = method.invoke(target3, args);
                System.out.println("记录用户执行操作的用户信息、更改内容和时间等");
                return obj;
            }
        });

        Object obj3 = proxy3.createOrder();
        System.out.println("queryOrder3 返回对象：" + obj3.getClass());
        System.out.println("----------------------------------");
        proxy3.queryOrder();
    }

}