package thread;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -14
 * Time: 14:56
 */
class A {
    public int x;
    public static int y;
}

public class TestStatic {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a1.x = 10;
        a2.x = 20;
        System.out.println("a1.x:" + a1.x);
        System.out.println("a2.x:" + a2.x);

        a1.y = 10;
        a2.y = 20;
        System.out.println("a1.y:" + a1.y);
        System.out.println("a2.y:" + a2.y);
        System.out.println("A.y:" + A.y);
    }
}
