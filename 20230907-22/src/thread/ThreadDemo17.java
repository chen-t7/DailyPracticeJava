package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -13
 * Time: 15:04
 */
public class ThreadDemo17 {
    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(() -> {
            //这个线程负责等待
            System.out.println("t1 ： wait 之前");
            try {
                synchronized (object) {
                    object.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 ： wait 之后");
        });

        Thread t2 = new Thread(() -> {
            //负责通知
            System.out.println("t2 : notify 之前");
            //notify 务必要获取到锁，才能进行通知
            synchronized (object) {
                object.notify();
            }
            System.out.println("t2 : notify 之后");
        });

        //如果直接t1.start()和t2.start()，由于线程调度的不确定性，此时不能保证一定是先执行wait，后执行notify
        //如果调用notify，此时没人wait，这种通知就是无效通知，也没啥副作用
        t1.start();
        //此处的sleep(500)大概率会让t1先执行wait的
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
