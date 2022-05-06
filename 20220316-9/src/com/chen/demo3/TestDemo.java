package com.chen.demo3;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -05
 * Time: 23:24
 */
class Animal {
    public String name = "hello";
    public int age;
    //private int count;
    protected int count;

    public Animal(String name, int age) {
        eat();
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + "ani::eat()");
    }
}

class Dog extends Animal {
    /*
    public Dog() {
        super();
    }
     */
    public Dog(String name, int age) {
        //super：显示调用构造方法，这里会调用父类带有两个参数的构造方法
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + "狗狼吞虎咽的eat()");
    }

    public void func(int a) {
        System.out.println("int");
    }

    public void func(int a, int b) {
        System.out.println("int, int");
    }

    public void func(int a, int b, int c) {
        System.out.println("int, int, int");
    }
}

class Bird extends Animal {
    public String wing;
    //如果子类中有何父类同名的变量，优先访问子类的变量
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

public class TestDemo {
    public static void main(String[] args) {
        Animal animal= new Dog("haha", 18);

    }

    //向下转转型
    public static void main5(String[] args) {
        Animal animal= new Dog("haha", 18);
        //判断animal引用的是否为Bird类型的对象
        if (animal instanceof Bird) {
            Bird bird = (Bird)animal;
            bird.fly();
        }
    }

    //向下转转型
    public static void main4(String[] args) {
        Animal animal2= new Bird("heihei", 27, "隐形的翅膀");
        Bird bird = (Bird)animal2;
        bird.fly();
    }

    public static void main3(String[] args) {
        Dog dog = new Dog("haha", 18);
        dog.func(2);
    }

    //动态绑定
    public static void main2(String[] args) {
        Animal animal= new Dog("haha", 18);
        animal.eat();

        Animal animal2= new Bird("heihei", 27, "隐形的翅膀");
        animal2.eat();
        System.out.println(animal2.name);//访问了父类的name
        //System.out.println(animal2.wing);//报错，通过父类引用，只能访问父类自己的成员，父类中没有wing
    }
    public static void func(Animal animal) {

    }

    public static Animal func2(Animal animal) {
        Dog dog = new Dog("haha", 18);
        //3.函数返回
        return dog;
    }

    //向上转型，父类引用 引用 子类的对象
    public static void main1(String[] args) {
        /*
        Dog dog = new Dog("haha", 18);
        Animal animal = dog;
         */
        //1.直接赋值
        Animal animal= new Dog("haha", 18);

        Dog dog = new Dog("haha", 18);
        //2.函数传参
        func(dog);
    }
}
