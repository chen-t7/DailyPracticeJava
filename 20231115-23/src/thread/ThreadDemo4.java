package thread;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -17
 * Time: 16:32
 */
public class ThreadDemo4 {
    public static void main1(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire(2);
        System.out.println("执行一次P操作");
        semaphore.acquire();
        System.out.println("执行一次P操作");
        semaphore.acquire();
        System.out.println("执行一次P操作");
        semaphore.acquire();
        System.out.println("执行一次P操作");

        semaphore.release();//V操作
    }
}
