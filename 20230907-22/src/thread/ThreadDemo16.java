package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -13
 * Time: 14:28
 */


public class ThreadDemo16 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait之前");
            object.wait();
            System.out.println("wait之后");
        }
    }
}
