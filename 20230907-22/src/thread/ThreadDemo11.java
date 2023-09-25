package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -09
 * Time: 12:36
 */
public class ThreadDemo11 {
    //线程状态转移
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //这个循环体啥也不干，也不sleep,获取到的时间是RUNNABLE
                //加上sleep，线程状态有可能是RUNNABLE   也可能是TIMED_WAITING
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        //启动之前获取t的状态，就是NEW状态
        System.out.println("start之前：" + t.getState());

        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("t 执行中的状态：" + t.getState());
        }
        t.join();

        //线程执行完毕之后，就是TERMINATED
        System.out.println("t结束之后： " + t.getState());
    }

    public static void main1(String[] args) {
        //线程的六种状态
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }
}
