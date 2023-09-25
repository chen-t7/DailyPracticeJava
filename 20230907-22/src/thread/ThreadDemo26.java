package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -19
 * Time: 10:44
 */
public class ThreadDemo26 {
    //使用标准库的线程池
    public static void main(String[] args) {
        //创建了一个线程池，池子里线程数目固定是10个
        //使用类的静态方法，直接构造出一个对象来----“工厂方法”----“工厂类”----“工厂模式
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            int n = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello" + n);
                }
            });
        }

    }
}
