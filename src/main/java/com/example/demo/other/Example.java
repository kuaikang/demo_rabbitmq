package com.example.demo.other;

/**
 * @Author: kuaik
 * @Date: 2018-10-09
 * @Description:
 */
public class Example {
    private Example() {
    }

//    private static final Example example = new Example();
//
//    public static Example getExample(){
//        return example;
//    }

//    private static Example ex = null;
//
//    synchronized public static Example getExample() {
//        if (null == ex) {
//            ex = new Example();
//        }
//        return ex;
//    }

    private static volatile Example example = null;

    public static Example getExample() {
        if (null == example) {
            synchronized (Example.class) {
                if (null == example) {
                    example = new Example();
                }
            }
        }
        return example;
    }

    public static void main(String[] args) {

    }
}
