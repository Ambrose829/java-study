package com.pika.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Pika
 * @create 2020/10/14
 * @since 1.0.0
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("1", "2");
        concurrentHashMap.remove("1", "2");



    }
}
