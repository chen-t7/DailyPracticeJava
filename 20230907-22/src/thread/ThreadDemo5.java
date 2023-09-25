package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -07
 * Time: 16:08
 */

//5.使用lambda表达式创建线程
public class ThreadDemo5 {
    public static void main(String[] args) {
        //直接把任务用lambda表达式来描述，直接把lambda传给Thread构造方法
        Thread t = new Thread(() -> {
            System.out.println("hello thread");
        });
        t.start();
    }
}
