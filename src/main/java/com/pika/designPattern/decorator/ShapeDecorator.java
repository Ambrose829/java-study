package com.pika.designPattern.decorator;

/**
 * 创建实现Shape接口的抽象装饰类
 */
public abstract class ShapeDecorator implements Shape{
    //创建一个需要被装饰的Shape
    Shape decorateShape;

    public ShapeDecorator(Shape decorateShape) {
        this.decorateShape = decorateShape;
    }

    public void draw() {
        decorateShape.draw();
    }
}
