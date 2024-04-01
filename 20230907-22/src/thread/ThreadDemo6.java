package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -08
 * Time: 15:36
 */
public class ThreadDemo6 {

    public static void main2(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "mythread");
        //t.setDaemon(true);//设置该线程为后台线程
        t.start();

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(t.isAlive());
                //t没start之前，t.isAlive()是false
                //t  start后，如果t中的run没执行完，t.isAlive()是true
                //t.run执行完之后，t.isAlive()是false
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        }, "mythread");
        t.setDaemon(true);//设置该线程为后台线程
        t.start();

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(t.isAlive());
                //false，当前t线程已经执行完毕，内核里的PCB被释放了，操作系统里的线程没了，但是t对象还在
                //t什么时候不在？啥时候引用不指向对象，被GC回收
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
