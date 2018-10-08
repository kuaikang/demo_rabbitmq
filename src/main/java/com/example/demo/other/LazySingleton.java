package com.example.demo.other;

/**
 * @Author: kuaik
 * @Date: 2018-10-08
 * @Description:
 */
public class LazySingleton {

    private LazySingleton() {
    }

    private static LazySingleton instance = null;

    synchronized public static LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /* 双重加锁机制*/
}
