package com.chen.demo2;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -01
 * Time: 23:55
 */
//父类/基类/超类
class Animal {
    public String name = "hello";
    public int age;
    //private int count;
    protected int count;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + "eat()");
    }
}

//子类/派生类
//extends 继承关键字
//子类构造的同时，要先帮助父类来进行构造。
class Dog extends Animal{
    /*
    public Dog() {
        super();
    }
     */
    public Dog(String name, int age) {
        //super：显示调用构造方法，这里会调用父类带有两个参数的构造方法
        super(name, age);
    }
}

final class Bird extends Animal{
    public String wing;
    //如果子类中有何父类同名的变量，优先访问子类的变量
    public String name;
    public Bird(String name, int age) {
        super(name, age);
    }

    public Bird(String name, int age, String wing) {
        super(name, age);
        this.wing = wing;
    }

    public void fly() {
        System.out.println(super.name + "fly()" + age);
    }
}

/*
如果一个类不想被继承，我们可以设置为final修饰。
//代表整个类，不可以被继承
class A extends Bird{
}
final int a = 10;//常量，不可以被修改
final //修饰方法
*/

public class TestDemo {
    public int val;
    protected int val2 = 99;

    public static void main3(String[] args) {
        Bird bird = new Bird("heihei", 27, "隐形的翅膀");
        System.out.println(bird.count);
    }

    public static void main2(String[] args) {
        Bird bird = new Bird("heihei", 27, "隐形的翅膀");
        System.out.println(bird.name);
        bird.fly();
    }

    public static void main1(String[] args) {
        Dog dog = new Dog("haha", 18);
        System.out.println(dog.name);
        dog.eat();

        Bird bird = new Bird("heihei", 27, "隐形的翅膀");
        System.out.println(bird.name);
        bird.eat();
        bird.fly();
    }
}

