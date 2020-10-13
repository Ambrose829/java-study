package com.pika.designPattern.decorator;

/**
 * 接口的实现类
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
