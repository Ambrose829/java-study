package com.pika.designPattern.proxy.dynamicProxy.jdk;

public class Person implements Eat {
    @Override
    public void eat() {
        System.out.println("Person 吃饭");
    }
}
