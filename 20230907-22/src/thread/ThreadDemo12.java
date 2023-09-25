package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -09
 * Time: 14:53
 */
//通过这个代码可以看到，多线程和单线程相比，效率的提升
    //多线程，在这种CPU密集型的任务中，有非常大的作用，可以充分利用CPU的多喝自愿，从而加快程序的运行效率
    //不是说多线程一定能提高效率，也取决于当前核心是否多核以及当前核心是否空闲
    //多线程在IO密集型的任务重，也是有作用的（客户端开发中比较常见）
public class ThreadDemo12 {
    public static void main(String[] args) {
        //假设当前有两个变量，需要把两个变量各自自增1000w次，（典型的CPU密集型的场景）
        //可以一个线程，先针对a自增，然后再针对b自增
        //还可以两个线程，分别对a和b自增
        //serial();
        concurrency();
    }

    //串行执行，一个线程完成
    public static void serial() {
        //为了衡量代码的执行速度，加上个计时的操作
        //currentTimeMillis ，获取到当前系统的ms级时间戳
        long beg = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间： " + (end - beg) + "ms");
    }

    //使用两个线程分别完成自增
    public static void concurrency() {
        Thread t1 = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                a++;
            }
        });
        Thread t2 = new Thread(() -> {
            long b = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                b++;
            }
        });
        //开始计时
        long beg = System.currentTimeMillis();
        t1.start();
        t2.start();

        //结束计时
        //不能直接计算时间差
        //t1  t2  main三个线程是并发执行的关系，main在执行完两个start之后，就会立即执行结束计时
        try {
            //要等t1和t2都执行结束后，才能计算时间差
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("并发执行时间： " + (end - beg) + "ms");
    }
}
