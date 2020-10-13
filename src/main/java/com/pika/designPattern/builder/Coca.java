package com.pika.designPattern.builder;

public class Coca extends ColdDrink {
    @Override
    public String name() {
        return "Coca Cola";
    }

    @Override
    public float price() {
        return 12.0f;
    }
}
