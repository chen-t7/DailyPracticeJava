package com.chen.demo7;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -11
 * Time: 22:48
 */
interface IA1 {
    void funcA();
}

interface IB1 extends IA1 {
    void funcB();
}

class C implements IB1 {
    @Override
    public void funcB() {
        System.out.println("hhhhh");
    }

    @Override
    public void funcA() {
        System.out.println("hhhhh");
    }
}
public class Test3 {
    public static void main(String[] args) {

    }
}
