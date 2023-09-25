package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -14
 * Time: 14:30
 */

//饿汉模式--单例模式实现
    //保证Singleton只能创建出一个实例
class Singleton{
    //在此处，先把实例创建出来了
    private static Singleton instance = new Singleton();

    //如果我们需要使用唯一实例，统一通过Singleton.getInstance()方式获取
    public static Singleton getInstance() {
        return instance;
    }

    //为了避免Singleton不小心被赋值多份来
    //把构造方法设置为private，在类外面，无法通过new的方式来创建这个Singleton实例了
    private Singleton(){
    }
}

//单例模式
public class ThreadDemo19 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        //Singleton s3 = new Singleton();//报错
        System.out.println(s1 == s2);
    }
}
