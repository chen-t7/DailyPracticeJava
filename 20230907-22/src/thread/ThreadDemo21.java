package thread;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -17
 * Time: 15:13
 */
public class ThreadDemo21 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.put("hello");
        String res = blockingQueue.take();
        System.out.println(res);

        res = blockingQueue.take();
        System.out.println(res);
    }
}
