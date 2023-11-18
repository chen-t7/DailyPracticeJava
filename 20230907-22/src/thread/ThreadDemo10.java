package thread;

import jdk.management.resource.internal.inst.ThreadRMHooks;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -08
 * Time: 22:37
 */
//线程是一个随机调度的过程。等待线程做的事情，就是控制两个线程的结束顺序
public class ThreadDemo10 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        //本身执行完start后，线程t和线程main就并发执行，分头行动
        //main继续往下执行，t也会继续往下执行

        //先等5秒再调join，让t执行结束之后再调用t.join
        //执行join的时候,t已经结束了，join不会阻塞，就会立即返回
        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

        System.out.println("join之前");

        //此处的join就是让当前的main线程来等待t线程执行结束（等待t的run执行完)
        try {
            //发生阻塞
            //一直阻塞到线程t执行结束后，main线程才会从join中恢复出来，才能继续往下执行
            //t肯定比main先结束
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("join之后");
    }
}
