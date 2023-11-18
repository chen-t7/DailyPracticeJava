package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -08
 * Time: 21:51
 */
public class ThreadDemo9 {
    //2.使用Thread自带的标志位来进行判定
    //这个东西可以唤醒sleep这样的方法
    //currentThread()是Thread类的静态方法，通过这个方法可以获取到当前线程，
    // 哪个线程调用的这个方法，就是得到哪个线程的对象引用，很类似于this
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //在t.run中调用currentThread()，此处获取的线程就是t线程
            //为true表示被终止，false表示未被终止
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //1.忽略请求，不处理
                    //e.printStackTrace();
                    //2.稍后处理

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                    //3.立即响应终止请求
                    //break;
                }
            }
        });
        t.start();
        Thread.sleep(3000);

        //终止线程，interrupt只是告诉你线程该终止了，但不是真的终止
        //interrupt会做两件事：
        //1.把线程内部的标志位（boolean）给设置成true
        //2.如果线程在进行sleep，就会触发异常，把sleep唤醒
        t.interrupt();
        //（但是sleep在唤醒的时候，还会做一件事，把刚才设置的标志位再设置为false（清空了标志位）
        //这就导致，sleep的异常被catch完了之后，循环还要继续执行，所以会再次打印
        //为啥sleep要清除标志位？
        //唤醒之后，线程到底要终止，还是不要，要立即终止还是稍后，把选择权交给程序员自己
    }
}
