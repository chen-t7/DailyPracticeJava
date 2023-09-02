/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -02 -16
 * Time: 23:23
 */
interface A {

}
class OuterClass {
    public int data1 = 1;
    public int data2 = 2;
    public static int data3 = 3;

    //实例内部类:可以把它当做是外部类的一个普通实例的成员
    class InnerClass {
        /*
        class Inner {

        }
         */

        public int data1 = 11;
        public int data4 = 4;
        private int data5 = 5;
        //public static int data6 = 6; //静态成员属于类，不属于对象
        public static final int data6 = 6;

        public InnerClass() {
            System.out.println("不带参数的内部类的构造方法");
        }

        public void test () {
            System.out.println(data1);
            System.out.println(OuterClass.this.data1);
            //实例内部类当做包含两个this，一个是外部类的this，一个是自己的this
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }

    public void func1() {
        //static int a = 10; 静态成员属于类，不属于对象
        System.out.println("OuterClass::func1()");
    }
}

class MyLinkedList {
    class Node2 {

    }
}
//内部类也可以被其他类继承
public class TestDemo2 extends OuterClass.InnerClass{
    public TestDemo2(OuterClass out) {
        out.super();
    }

    public void func() {
        class Test {
            public int a;
        }
            //缺点：只能在当前方法使用
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.func1();
        //实例化一个实例内部类对象
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }
}
