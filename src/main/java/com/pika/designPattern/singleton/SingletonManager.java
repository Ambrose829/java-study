package com.pika.designPattern.singleton;

        import java.util.HashMap;

/**
 * 容器管理单例模式
 */
public class SingletonManager {
    private static HashMap<String, Object> map = new HashMap<>();
    private SingletonManager() {

    }
    public static void registerService(String str, Object instance) {
        if (!map.containsKey(str)) {
            map.put(str, instance);
        }
    }
    public static Object getService(String str) {
        return map.get(str);
    }
}
