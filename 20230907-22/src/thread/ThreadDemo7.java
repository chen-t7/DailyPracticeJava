package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -08
 * Time: 16:42
 */
public class ThreadDemo7 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello thread");
        });
        t.start();
        System.out.println("hello main");
        //这两条打印的执行顺序，是不确定的，完全随机的
    }
}
