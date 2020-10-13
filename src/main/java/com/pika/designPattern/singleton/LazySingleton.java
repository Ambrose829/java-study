package com.pika.designPattern.singleton;

/**
 * 懒汉模式
 * 类加载速度快，获取对象速度慢
 */
public class LazySingleton {
    //私有静态成员，没有初始化
    private static LazySingleton instance = null;

    private LazySingleton() {

    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
