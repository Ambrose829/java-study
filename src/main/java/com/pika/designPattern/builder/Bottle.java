package com.pika.designPattern.builder;
//建实现 Packing 接口的实体类
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
