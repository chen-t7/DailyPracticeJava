package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -07
 * Time: 15:41
 */
//2.实现runnable接口
//Runnable作用，是描述一个“要执行的任务”，run方法就是任务的执行细节
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hello thread");
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        //这只是描述了个任务，还要把任务交给线程去执行
        Runnable runnable = new MyRunnable();
        //解耦合，目的是为了让线程和线程之间要干的活之间分离开来
        //未来如果要改代码，不用多线程，使用多进程或者线程池，或者协程...此时改动代码较小
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
