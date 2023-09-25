package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -13
 * Time: 16:28
 */

public class ThreadDemo18 {
    //有三个线程，分别只能打印A,B,C，控制三个线程固定按照ABC的顺序来打印
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println("A");
            synchronized (locker1) {
                locker1.notify();
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            synchronized (locker2) {
                locker2.notify();
            }
        });

        Thread t3 = new Thread(() -> {
            synchronized (locker2) {
                try {
                    locker2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
        });

        //需要保证t2和t3 先执行wait，再让t1  notify，否则会出现死等
        t2.start();
        t3.start();
        Thread.sleep(100);
        t1.start();
    }
}
