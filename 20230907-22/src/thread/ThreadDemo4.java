package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -07
 * Time: 16:01
 */

//4.使用匿名内部类，实现Runnable
    //这个方法和2本质相同，只不过把实现Runnable任务交给匿名内部类的语法
    //此处是创建了一个类，实现Runnable，同时创建了类的实例，并且传给Thread的构造方法
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        });
        t.start();
    }
}
