package com.pika.designPattern.singleton;

/**
 * 枚举类单例模式
 */
public enum EnumSingleton {
    INSTANCE;
    private Instance instance;
    private EnumSingleton() {
        instance = new Instance();
    }
    public Instance getInstance() {
        return instance;
    }
}

class Instance {}