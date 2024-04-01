package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -18
 * Time: 22:37
 */
public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
        countDownLatch.await();
        System.out.println("比赛结束");
    }
}
