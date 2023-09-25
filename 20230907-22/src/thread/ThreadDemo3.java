package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -07
 * Time: 15:55
 */

//3.使用匿名内部类，继承Thread
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        };
        t.start();
    }
}
