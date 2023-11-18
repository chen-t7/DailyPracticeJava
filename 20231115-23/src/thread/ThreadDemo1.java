package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -15
 * Time: 14:44
 */
public class ThreadDemo1 {
    //使用原子类，来解决线程安全问题
    public static void main(String[] args) throws InterruptedException {
        //这些原子类，就是基于CAS实现了自增自减等操作，此时进行这类操作不需要加锁，也是线程安全的
        AtomicInteger count = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                //因为java不支持运算符重载，所以只能使用普通方法来表示自增自减
                count.getAndIncrement();//count++
                //count.incrementAndGet();//++count
                //count.getAndDecrement();//count--
                //count.decrementAndGet();//--count
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count.get());
    }

}
