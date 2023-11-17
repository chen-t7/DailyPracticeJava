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

        //get方法就是获取结果。get会发生阻塞，直到callable执行完毕，get才阻塞，完成，才获取到结果
        Integer result = futureTask.get();
        System.out.println(result);
    }
}
