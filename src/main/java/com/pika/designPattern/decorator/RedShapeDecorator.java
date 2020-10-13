package com.pika.designPattern.decorator;

/**
 * 创建了拓展ShapeDecorator的实体装饰器
 */
public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape decorateShape) {
        super(decorateShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decorateShape);
    }

    public void setRedBorder(Shape decorateShape) {
        System.out.println("Border: Red");
    }
}
