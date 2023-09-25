package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -11
 * Time: 14:03
 */
class Counter {
    public int count;


    //加锁，synchronized 获取不到锁，就阻塞等待（锁竞争/锁冲突）
    //synchronized 使用方法：
    //          1.修饰方法
    //            1)修饰普通方法  都是进入方法就加锁，离开方法就解锁
    //            2)修饰静态方法  这两种操作，加锁的“对象”不同锁对象相同，就会产生锁竞争，产生阻塞等待，锁对象不同就不会产生锁竞争
    //              [修饰普通方法，锁对象就是this，修饰静态方法，锁对象就是类对象，修饰代码块，显示/手动指定锁对象]
    //          2.修饰代码块

    //修饰普通方法
    synchronized public void add() {
        count++;
    }

    public void add2() {
        //修饰代码块，这里的this可以任务指定你想要指定的对象，也不一定非得是this
        //进入代码块就加锁，出了代码块就解锁
        synchronized (this) {
            count++;
        }
    }


    public void add3() {
        count++;
    }

    synchronized public void add4() {
        //一个线程针对同一个对象，连续加锁两次，是否会有问题？ 如果没问题，就叫可重入，如果有问题，就叫不可重入的
        //锁对象是this，只要有线程调用add4，进入add4方法的时候，就会先加锁（能够加锁成功），紧接着又遇到了代码块，再次尝试加锁
        //站在this的视角（锁对象），他认为自己已经被另外的线程给占用了，这里的第二次加锁是否要阻塞等待呢
        //此处是特殊情况，第二个线程，和第一个线程，其实是同一个线程
        //如果允许上述操作，这个锁就是可重入的，如果不允许上述操作（第二次加锁就会阻塞等待），就是不可重入的【这个情况就会导致线程“僵住了”，死锁了】
        //为了避免不小心死锁，java就把synchronized设定成可重入的了
        //就是在锁对象里记录一下，当前的锁是哪个线程持有的，如果加锁线程和持有线程是同一个，就直接放过，否则就阻塞
        synchronized (this) {
            count++;
        }
    }
}

public class ThreadDemo13 {
    //线程安全问题
    public static void main(String[] args) {
        Counter counter = new Counter();

        //搞两个线程，两个线程分别针对counter来调用5w次的add方法
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                //如果一个加锁，一个不加锁，即一个调用add，一个调用add3，是不会产生锁竞争的，还是抢占式执行
                counter.add();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add2();
            }
        });

        t1.start();
        t2.start();
        //等待两个线程结束
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count= " + counter.count);
    }
}
