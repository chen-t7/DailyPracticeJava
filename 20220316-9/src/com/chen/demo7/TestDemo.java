package com.chen.demo7;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -11
 * Time: 22:16
 */

interface IShape {

    public abstract void draw();//void draw();不加也会默认是public abstract的

    default public void func() {
        System.out.println("hhhhhh");
    }

    default public void func2() {
        System.out.println("hhhhhh");
    }

    public static void funcStatic() {
        System.out.println("hhhhhh");
    }

}

class Rect implements IShape {
    @Override
    public void draw() {
        System.out.println("♦");
    }


    @Override
    public void func() {
        System.out.println("重写接口当中的默认方法");
    }


}

class Flower implements IShape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle implements IShape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}

class Cycle implements IShape {
    @Override
    public void draw() {
        System.out.println("○");
    }
}

public class TestDemo {
    public static void drawMap(IShape iShape) {
        iShape.draw();
    }

    public static void main(String[] args) {
        IShape iShape1 = new Flower();
        iShape1.draw();
        IShape iShape2 = new Cycle();
        iShape2.draw();
    }

    public static void main1(String[] args) {
        //IShape iShape = new IShape();//error
        IShape iShape = new Rect();
        iShape.draw();
    }
}
