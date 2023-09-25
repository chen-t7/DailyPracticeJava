package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -19
 * Time: 14:11
 */

class MyThreadPool {
    //此处队列里只有任务，直接使用Runnable即可
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    //n表示线程的数量
    public MyThreadPool (int n) {
        //在这里创建出线程
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

    //注册任务给线程池
    public void submit (Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadDemo27 {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int n = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello " + n);
                }
            });
        }
    }
}
