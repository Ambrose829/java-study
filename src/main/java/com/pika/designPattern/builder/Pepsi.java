package com.pika.designPattern.builder;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi Cola";
    }

    @Override
    public float price() {
        return 12.0f;
    }
}
