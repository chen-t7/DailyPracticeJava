package com.chen.demo7;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -11
 * Time: 22:34
 */
interface IA {
    public static final int A = 10;//默认是public static final的，所以必须初始化  int A = 20
    void  funcA();//public abstract
}

interface IB {
    void funcB();
}

abstract class BClass {

}

class AClass extends BClass implements IA, IB {
    @Override
    public void funcA() {
        System.out.println("AClass::funcA()");
        System.out.println(A);
    }

    @Override
    public void funcB() {
        System.out.println("AClass::funcB()");
    }
}


public class Test2 {
    public static void main(String[] args) {

    }
}
