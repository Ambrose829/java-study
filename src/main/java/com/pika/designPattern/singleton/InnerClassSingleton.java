package com.pika.designPattern.singleton;

/**
 * 静态内部类单例模式
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {

    }
    private static class SingletonHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
        private SingletonHolder() {

        }
    }
    public static InnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
