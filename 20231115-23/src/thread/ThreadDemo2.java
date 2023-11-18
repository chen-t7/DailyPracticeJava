package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -16
 * Time: 16:32
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //使用Callable来计算1+2+3+...+1000
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        //在主线程中调用 futureTask.get() 能够阻塞等待新线程计算完毕. 并获取到 FutureTask 中的结果
        Integer result = futureTask.get();
        System.out.println(result);
    }

    static class Result {
        public int sum = 0;
        public Object lock = new Object();
    }

    //不使用Callable来计算1+2+3+...+1000
    public static void main1(String[] args) throws InterruptedException {
        Result result = new Result();
        Thread t = new Thread(() -> {
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            synchronized (result.lock) {
                result.sum = sum;
                result.lock.notify();
            }
        });
        t.start();
        synchronized (result.lock) {
            while (result.sum == 0) {
                result.lock.wait();
            }
            System.out.println(result.sum);
        }
    }
}
