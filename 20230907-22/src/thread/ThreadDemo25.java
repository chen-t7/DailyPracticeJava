package thread;

import java.sql.SQLOutput;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -18
 * Time: 14:37
 */

//使用这个类来表示定时器中的任务
class MyTask implements Comparable<MyTask>{
    //要执行的任务内容
    private Runnable runnable;
    //任务啥时候执行（使用毫秒时间戳表示）
    private long time;

    public MyTask (Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = time;
    }

    //获取当前任务的时间
    public long getTime() {
        return time;
    }

    //执行当前任务内容
    public void run(){
        runnable.run();
    }

    @Override
    public int compareTo(MyTask o) {
        //返回 <0  == 0  >0
        //this 比 o小，返回小于0
        //当前想要的效果是，队首元素是最小的
        return (int)(this.time - o.time);
    }
}

//实现定时器
class MyTimer {
    //扫描线程
    private Thread t = null;
    //有一个阻塞优先级队列，来保存任务
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    //专门使用这个对象来进行加锁/等待通知
    private Object locker = new Object();
    public MyTimer() {
        t = new Thread(() -> {
            while (true) {
                try {
                    //取出队首元素，检查看看队首元素任务是否到时间了
                    //如果时间没到，就把任务塞回队列里
                    //如果时间到了，就把任务进行执行
                    //阻塞队列只能先把队列拿出来才能判定，不像普通队列，可以直接用队首元素进行判定
                    //如果一直取出放进去的都是同一个Task，就会出现忙等现象
                    //不想进行忙等了，而是要进行“阻塞式”等待
                    //随时可能有新的任务到来（随时有可能有线程调用schedule添加新任务），如果新任务更早用sleep会错过新任务的执行时间
                    //使用带超时时间的wait
                    synchronized (locker) {
                        MyTask myTask = queue.take();
                        long curTime = System.currentTimeMillis();
                        if (curTime < myTask.getTime()) {
                            //还没到点，不必执行
                            queue.put(myTask);
                            //不放新元素就阻塞式等待，到时间就执行队首元素任务
                            locker.wait(myTask.getTime()-curTime);
                        } else {
                            myTask.run();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
    //指定两个参数
    //第一个参数是 任务内容
    //第二个参数是任务在多少毫秒之后执行
    public void schedule(Runnable runnable, long after) {
        //要对时间进行换算
        MyTask myTask = new MyTask(runnable, System.currentTimeMillis() + after);
        queue.put(myTask);
        synchronized (locker) {
            //放入新元素时唤醒队列，让队首元素重新进行比较，看看队首元素是否到时间执行
            locker.notify();
        }
    }
}

public class ThreadDemo25 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        },1000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务2");
            }
        },2000);
    }
}
