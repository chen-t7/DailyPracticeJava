package com.chen.demo5;

import javafx.scene.shape.Circle;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -06
 * Time: 23:35
 */
abstract class Shape {
    public int a;
    public void func() {
        System.out.println("普通方法");
    }
    public abstract void draw();//抽象方法
}

abstract class A extends Shape {
    public abstract void funcA();
}

class B extends A {
    @Override
    public void funcA() {

    }

    @Override
    public void draw() {
        
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦" + a);
        //super.func();
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("○");
    }
}

public class Test {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        //Shape shape = new Shape();//抽象类是不可以被实例化的
        Shape shape = new Rect();//但是可以进行向上转型
        drawMap(shape);

        Cycle cycle = new Cycle();
        drawMap(cycle);
    }
}
