package com.chen.demo7;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -11
 * Time: 22:54
 */
class Animal {
    protected String name;

    public Animal (String name) {
        this.name = name;
    }

}

//不是所有的动物都会飞，所以不能都写到Animal中。如果写到另一个类中也不行，因为一个类只能继承一个类
interface IFlying {
    void fly();
}

interface ISwimming {
    void swim();
}

interface IJumpping {
    void jump();
}

interface IRunning {
    void run();
}
class Bird extends Animal implements IFlying{

    public Bird (String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name + "正在飞");
    }
}

class Frog extends Animal implements IRunning, IJumpping, ISwimming {
    public Frog (String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在游");
    }

    @Override
    public void jump() {
        System.out.println(this.name + "正在跳");
    }
}

class Duck extends Animal implements  IRunning, ISwimming {
    public Duck (String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在游");
    }
}

class Robot implements IRunning {
    @Override
    public void run() {
        System.out.println("机器人跑步");
    }
}
public class Test4 {
    public static void runFunc (IRunning iRunning) {
        iRunning.run();
    }

    public static void swimmingFunc (ISwimming iSwimming) {
        iSwimming.swim();
    }

    public static void flyyingFunc (IFlying iFlying) {
        iFlying.fly();
    }

    public static void main(String[] args) {
        runFunc(new Duck("chen"));
        runFunc(new Frog("yu"));
        runFunc(new Robot());

        swimmingFunc(new Duck("chen"));
        swimmingFunc(new Frog("yu"));

        flyyingFunc(new Bird("hhh"));
    }
}
