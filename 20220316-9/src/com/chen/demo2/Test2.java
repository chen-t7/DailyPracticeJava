package com.chen.demo2;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -05
 * Time: 23:30
 **/

public class Test2 {
    public int val = 10;
    protected int val2 = 1999;
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.val2);
    }

    public static void main1(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.val);
        System.out.println(testDemo.val2);
    }
}
