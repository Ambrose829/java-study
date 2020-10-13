package com.pika.designPattern.singleton;

/**
 * 饿汉模式
 * 天然线程安全
 * 类加载时创建时创建实例，所以类加载较慢，但是获取对象的速度快
 */
public class HungrySingleton {
    //私有静态成员
    //在类加载时就已经完成初始化
    private static HungrySingleton instance = new HungrySingleton();
    //私有构造函数
    private HungrySingleton() {

    }
    //静态
    public static HungrySingleton getInstance() {
        return instance;
    }
}
