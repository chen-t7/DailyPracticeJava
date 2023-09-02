import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -02 -16
 * Time: 23:57
 */

class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    //静态内部类:可以把它当做一个静态成员
    static class InnerClass {
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        public InnerClass() {
            System.out.println("InnerClass");
        }

        public OuterClass2 out2 = new OuterClass2();
        public OuterClass2 out;
        public InnerClass(OuterClass2 out) {
            this.out = out;
        }

        public void test() {
            //
            System.out.println(new OuterClass2().data1);
            System.out.println(out.data2);
            System.out.println(out2.data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }

}

class Test {
    public void test() {
        System.out.println("test()haha!");
    }
}
public class TestDemo3 {
    public static void main3(String[] args) {
        //匿名内部类
        new Test() {
            @Override
            public void test() {
                System.out.println("我是重写的test()");
            }
        }.test();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }

    public static void main2(String[] args) {
        OuterClass2.InnerClass innerClass= new OuterClass2.InnerClass();
    }

    public static void main1(String[] args) {
        OuterClass2 o = new OuterClass2();
        //创建静态内部类的对象
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass(o);
        innerClass.test();
    }


}
