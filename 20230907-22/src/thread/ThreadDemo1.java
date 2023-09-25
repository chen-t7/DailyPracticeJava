package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -07
 * Time: 14:05
 */
//Java中创建线程的写法
//1.继承Thread类，重写run
class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("hello thread");
            //打印慢点方便看，加个sleep休眠一秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo1 {

    public static void main2(String[] args) {
        Thread t = new MyThread();
        //new一个Thread对象不创建线程（说的线程指的是系统内核里的PCB），调用start才是创建PCB，才是有真实的线程的
        t.start();
        //t.run();
        //start和run之间的区别：start是真正创建了一个线程（从系统这里创建的），线程是独立的执行流
        //run只是描述了线程要干的活是啥，如果直接在Main中调用run，此时没有创建新线程，全是main线程一个人干活
        //并发的优势，
        while (true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //hello main
        //hello thread
        //hello main
        //hello thread
        //hello thread
        //hello main
        //操作系统调度线程的时候，是“抢占式执行”，具体那个线程先上，哪个后上，不确定，取决于操作系统调度器具体实现策略
        //虽然有优先级，但是在应用程序层面上无法修改，看到的结果好像线程之间的调度顺序好像是“随机”的一样，内核里本身并不随机，
        // 但是干预因素太多，并且应用程序这一层也无法感知到细节，只能认为是随机的了
    }

    public static void main1(String[] args) {
        //Thread类在使用过程中，不需要import导入别的包。因为Thread在java.lang下，默认导入。
        //String,StringBuilder,StringBuffer也是不需要导入的
        Thread t = new MyThread();
        //创建线程是希望线程能成为一个独立的执行流（执行一段代码）
        t.start();//线程中的特殊方法，启动一个线程。start这里的工作就是创建了一个线程，由新的线程负责执行t.run()
        //就是调用操作系统的API，通过操作系统内核创建新线程的PCB，并且把要执行的指令交给这个PCB，
        // 当PCB被调度到CPU上执行的时候，也就执行到了线程的run方法中的代码了
        System.out.println("hello world");
        //直接打印和创建一个线程打印的区别？：
        //如果只是直接打印hello world，这时候的java进程主要就是有一个线程（调用main方法的线程），主线程
        //通过t.start()，主线程调用t.start，创建出一个新的线程，新的线程调用t.run
        //如果run方法执行完毕，新的这个线程自然销毁。
    }
}
