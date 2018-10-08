package com.example.demo.other;

/**
 * 懒汉式：一开始就创建实例
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
