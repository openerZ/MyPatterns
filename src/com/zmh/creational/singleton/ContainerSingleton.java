package com.zmh.creational.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 存放单例模式的容器
 */
public class ContainerSingleton {
    private ContainerSingleton(){}

    //用来存放单例对象
    private static final Map<String,Object> map = new HashMap<>();

    public static void putInstance(String key,Object obj){
        if (key!=null&&obj!=null) {
            if (!map.containsKey(key)) {
                map.put(key, obj);
            }
        }
    }

    public static Object getInstance(String key){
        return map.get(key);
    }

}
