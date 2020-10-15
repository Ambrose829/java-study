package com.pika.collection;

import java.util.HashMap;

/**
 * @author Pika
 * @create 2020/10/14
 * @since 1.0.0
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "2");
        String oldValue = hashMap.put("1", "3");
        hashMap.remove("1", 3);
        System.out.println(oldValue);

        hashMap.get("1");
    }
}
