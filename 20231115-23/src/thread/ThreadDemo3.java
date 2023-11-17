package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -11 -17
 * Time: 15:26
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        boolean result = reentrantLock.tryLock();
        try {
            if (result == true) {
                //需要考虑线程安全的操作
            } else {
                //啥都不做
            }
        } finally {
            if (result == true) {
                reentrantLock.unlock();
            }
        }
    }
}
