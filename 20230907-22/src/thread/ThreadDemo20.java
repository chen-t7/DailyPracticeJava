package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -14
 * Time: 15:04
 */
//懒汉模式--单例模式
class SingletonLazy {
    private volatile static SingletonLazy instance = null;

    //这个实例并非是类加载的时候就创建了，而是等到第一次使用的时候才创建，如果不用就不创建了
    //线程不安全版本
    /*
    public static SingletonLazy getInstance() {
        //既要读又要写，线程不安全的
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
     */
    //线程安全版本
    //每次调用getInstance()都需要加锁，开销太大；对象创建以后调用getInstance()都是读操作，没必要每次加锁
    /*
    public synchronized static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
     */

    public static SingletonLazy getInstance() {
        //不是无脑加锁，而是判断符合条件了才加锁
        //第一个if判断是否要加锁
        if (instance == null) {
            synchronized (Singleton.class) {
                //第二个if判定是否要创建对象
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }

        return instance;
    }

    private SingletonLazy() {
    }
}

public class ThreadDemo20 {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2);
    }
}
