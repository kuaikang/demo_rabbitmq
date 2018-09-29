package com.example.demo.other;

/**
 * @Author: kuaik
 * @Date: 2018-09-29
 * @Description:
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer n1 = new Integer(10);
        int n2 = 10;
        Integer n3 = new Integer(10);
        Integer n4 = 10;
        System.out.println(n1 == n2);
        System.out.println(n1 == n3);
        System.out.println(n1 == n4);
        Integer n5 = 127;
        Integer n6 = 127;
        Integer n7 = 1111;
        Integer n8 = 1111;
        System.out.println(n5 == n6);
        System.out.println(n7 == n8);
    }
}
