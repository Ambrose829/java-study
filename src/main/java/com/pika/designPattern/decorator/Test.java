package com.pika.designPattern.decorator;

public class Test {
    public static void main(String[] args) {
        RedShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        RedShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        redCircle.draw();
        System.out.println("-----------------------");
        redRectangle.draw();
    }
}
