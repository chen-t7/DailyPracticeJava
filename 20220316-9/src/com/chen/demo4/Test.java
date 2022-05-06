package com.chen.demo4;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -06
 * Time: 23:12
 */
class Shape {
    public void draw() {
        System.out.println("draw()");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("♦");
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

class Circle extends Shape {
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
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        Shape[] shapes = {triangle, rect, rect, flower};
        for (Shape sh : shapes) {
            sh.draw();
        }
    }

    public static void main3(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        String[] shapes = {"triangle", "rect", "rect", "flower"};
        for (String st : shapes) {
            if (st.equals("triangle")) {
                triangle.draw();
            } else if (st.equals("rect")) {
                rect.draw();
            } else if (st.equals("flower")) {
                flower.draw();
            }
        }
    }

    public static void main2(String[] args) {
        Rect rect = new Rect();
        drawMap(rect);

        Flower flower = new Flower();
        drawMap(flower);

        Triangle triangle = new Triangle();
        drawMap(triangle);
    }

    public static void main1(String[] args) {
        Shape shape1 = new Rect();
        shape1.draw();

        Shape shape2 = new Flower();
        shape2.draw();
    }
}
