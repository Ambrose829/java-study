package com.pika.designPattern.singleton;

/**
 * 使用双重判断对懒汉模式进行优化
 */
public class DCLSingleton {
    //私有静态成员，没有初始化
    //使用DCL必须要使用volatile修饰，否则DCL可能失效
    private static volatile DCLSingleton instance = null;
    private DCLSingleton() {

    }
    public static DCLSingleton getInstance() {
        //缩小synchronized的范围，提高性能
        //第一次判断，避免不必要的同步
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                //第二次判断，为了避免多个线程都进入到了这里后，创建出多个单例对象
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
