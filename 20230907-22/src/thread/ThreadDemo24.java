package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -18
 * Time: 14:19
 */
public class ThreadDemo24 {
    public static void main(String[] args) {
        System.out.println("程序启动");
        //标准库的定时器
        Timer timer = new Timer();
        //这个方法的效果是给定时器注册一个任务，这个任务不会立即执行，而是在指定时间执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时器任务1");
            }
        }, 3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时器任务2");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时器任务3");
            }
        }, 1000);
    }
}
