//psvm-->main函数
//sout-->打印
public class TestDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a >= b);
    }
    public static void main5(String[] args) {
        int a = 10;
        int i1 = a++;//先使用后++  i1=a a=a+1
        System.out.println(a);//11
        System.out.println(i1);//10

        int c = 10;
        int i2 = ++c;//先++后使用  c=c+1 i2=c
        System.out.println(c);//11
        System.out.println(i2);//11
    }
    public static void main4(String[] args) {
        int a = 10;
        a += 1;
        System.out.println(a);

        short sh = 10;
        //sh = (short)(s + 9);
        sh += 9;//自动进行强制类型转换
        short s = 1;
        s = sh;
    }
    public static void main3(String[] args) {
        System.out.println(10%3);//1
        System.out.println(11.5%2);//1.5
        System.out.println(-10%3);//-1
        System.out.println(10%-3);//1
        System.out.println(-10%-3);//-1
    }
    public static void main2(String[] args) {
        int a = 1;
        int b = 0;
        System.out.println(a/b);
        System.out.println("scjwidbi");
    }
    public static void main1(String[] args) {
        System.out.println("helolo");
    }
}
