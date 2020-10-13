package com.pika.designPattern.builder;

/**
 * 香辣鸡腿堡
 */
public class ZingerBurger extends Burger {
    @Override
    public String name() {
        return "香辣鸡腿堡";
    }

    @Override
    public float price() {
        return 24.0f;
    }
}
