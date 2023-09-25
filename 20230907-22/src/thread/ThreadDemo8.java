package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -08
 * Time: 21:24
 */
//线程终止
public class ThreadDemo8 {

    private static boolean flg = true;
    //1.自定义变量，使用标志位来控制线程是否停止
    //缺点：自定义变量这种方式，不能及时响应，尤其是在sleep休眠时间比较久的时候
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (flg) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //在主线程里就可以随时通过flg变量的取值，来操作t线程是否结束
        flg = false;
    }
}
