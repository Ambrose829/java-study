package com.pika.designPattern.proxy.dynamicProxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib实现动态代理
 * cglib实现动态代理不需要接口
 * 需要导入一个cglib的依赖
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new LogMethodInterceptor());
        Person person = (Person) enhancer.create();
        person.eat();

    }
}

class LogMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始吃...");

        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("吃完了...");
        return result;
    }
}

