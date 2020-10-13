package com.pika.designPattern.builder;

/**
 * 牛肉堡
 */
public class BeefBurger extends Burger {
    @Override
    public String name() {
        return "牛肉堡";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
