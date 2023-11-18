package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -17
 * Time: 15:29
 */
public class ThreadDemo22 {
    //生产者消费者模型
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        //创建两个线程，分别当做生产者和消费者
        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    Integer result = blockingQueue.take();
                    System.out.println("消费元素: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        customer.start();

        Thread product = new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    blockingQueue.put(count);
                    System.out.println("生产元素：" + count);
                    count++;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        product.start();
    }
}
