package thread;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -13
 * Time: 12:24
 */

class MyCounter {
    //public int flag = 0;//出现bug，内存可见性问题
    //解决办法：加上volatile关键字，意思是告诉编译器，这个变量是“易变”的，一定要每次都重新读取这个变量的内存内容
    volatile public int flag = 0;
}

public class ThreadDemo15 {
    //内存可见性问题
    //预期：t2线程修改了myCounter.flag 的值，为不等于0的时候，t1线程应跳出循环
    //实际：没有
    //一个线程针对一个变量进行读取操作，同时另一个线程针对这个变量进行修改，
    // 此时读到的值，不一定是修改之后的值，此时读线程没有感知到变量的变化
    // （归根结底是编译器/JVM在多线程环境下优化时产生了误判）
    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();

        Thread t1 = new Thread(() -> {
            while (myCounter.flag == 0) {
                //空
            }
            System.out.println("t1循环结束 ");
        });

        Thread t2 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个整数： ");
            myCounter.flag = sc.nextInt();
        });

        t1.start();
        t2.start();
    }

}
