package com.pika.designPattern.strategy.comparator;

public class Square {
    private double length;
    private double width;

    public Square(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public  double getArea() {
        return length * width;
    }
}
