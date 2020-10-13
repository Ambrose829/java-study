package com.pika.designPattern.decorator;

/**
 * 接口的实现类
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
