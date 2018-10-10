package com.example.demo.other;

/**
 * @Author: kuaik
 * @Date: 2018-10-10
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        try {
            Class testClassLoad = Class.forName("com.example.demo.other.TestClassLoad");
            System.out.println(testClassLoad.getName());


            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            Class loadClass = systemClassLoader.loadClass("com.example.demo.other.TestClassLoad1");
            loadClass.newInstance();
            System.out.println(loadClass.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
