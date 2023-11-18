package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -12
 * Time: 16:16
 */
public class ThreadDemo14 {
    //死锁破解方法：给多把锁编号，按照固定顺序加锁；
    // 线程t1和线程t2，都先拿locker1，线程t1拿到locker1之后，线程t2进行阻塞等待，直至t1释放locker1
    public static void main2(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    //确保两个线程先把第一个锁拿到。否则不容易构造出来，线程是抢占式执行的
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {
                    System.out.println("两把锁都被t1拿到了");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {
                    System.out.println("两把锁都被t2拿到了");
                }
            }
        });

        t1.start();
        t2.start();
    }

    //死锁。两个线程两把锁，t1和t2各自现针对锁A和锁B加锁，再尝试获取对方的锁。
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    //确保两个线程先把第一个锁拿到。否则不容易构造出来，线程是抢占式执行的
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {
                    System.out.println("两把锁都被t1拿到了");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker1) {
                    System.out.println("两把锁都被t2拿到了");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
