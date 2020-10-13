package com.pika.designPattern.proxy.dynamicProxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 利用反射，实现动态代理
 * jdk的动态代理，代理类必须要实现接口
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        final Person person = new Person();

        //在使用jdk的动态代理时，会自动生成一个代理类，可以选择在项目中显示或者不显示。
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Eat personProxy = (Eat) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Eat.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始吃...");
                Object o = method.invoke(person, args);
                System.out.println("吃完了...");
                return o;
            }
        });
        personProxy.eat();
    }
}
