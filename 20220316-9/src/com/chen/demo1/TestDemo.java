package com.chen.demo1;

import com.chen.demo2.Test2;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -01
 * Time: 23:30
 */
public class TestDemo extends Test2{

    public void func() {
        System.out.println(super.val2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.val);
        //System.out.println(test2.val2);
    }
    public static void main1(String[] args) {
        Test test = new Test();
        System.out.println(test.val);
    }
}
