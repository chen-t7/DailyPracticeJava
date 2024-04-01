package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -17
 * Time: 15:38
 */
//创建阻塞队列，先不考虑泛型
    //使用循环队列实现
    //阻塞环境意味着，队列要在多线程环境下使用
class MyBlockingQueue {
    private int[] items = new int[1000];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    //入队
    public void put(int value) throws InterruptedException {
        synchronized (this) {
            //队列满了，不能继续插入，需要进行阻塞等待
            //if (size == items.length) { //为啥不用if?用while写是进行了多次判定，满了就一直等待，if只能判定一次
            while (size == items.length) {
                //return;
                this.wait();
            }
            items[tail] = value;
            tail++;
            //tail = tail % items.length;
            if (tail >= items.length) {
                tail = 0;
            }
            size++;

            //这个notify唤醒的是take中的wait
            this.notify();
        }
    }

    //出队
    public Integer take() throws InterruptedException {
        int result = 0;
        synchronized (this) {
            while (size == 0) {
                //队列空  无法出队列  应该进行阻塞
                this.wait();
            }

            result = items[head];
            head++;
            if (head >= items.length) {
                head = 0;
            }
            size--;
            //唤醒put中的wait
            this.notify();
        }
        return result;
    }

}
public class ThreadDemo23 {
    public static void main(String[] args) throws InterruptedException {
        /*MyBlockingQueue blockingQueue = new MyBlockingQueue();
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        blockingQueue.put(4);

        int result = 0;
        result = blockingQueue.take();
        System.out.println("出队列：" + result);
        result = blockingQueue.take();
        System.out.println("出队列：" + result);
        result = blockingQueue.take();
        System.out.println("出队列：" + result);
        result = blockingQueue.take();
        System.out.println("出队列：" + result);*/


        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    Integer result = myBlockingQueue.take();
                    System.out.println("消费了： " + result);

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        customer.start();

        Thread producer = new Thread(() -> {
            int count= 0;
            while (true) {
                try {
                    System.out.println("生产了： " + count);
                    myBlockingQueue.put(count);
                    count++;

                    //Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
    }
}
