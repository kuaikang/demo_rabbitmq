package com.example.demo.other;

/**
 * @Author: kuaik
 * @Date: 2018-09-28
 * @Description:
 */
public class Singleton {
    private Singleton() {
    }
    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}
