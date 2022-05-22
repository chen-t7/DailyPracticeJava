/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -22
 * Time: 21:24
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Integer a = -129;
        Integer b = -129;
        System.out.println(a == b);
    }

    public static void main2(String[] args) {
        Integer a = 123;//装箱  【隐式的】
        int b = a;//拆箱   【隐式的】
        System.out.println(a + ' ' +b);

        System.out.println("=================");

        Integer a2 = Integer.valueOf(123);//装箱  【显式的】
        Integer a3 = new Integer(123);//拆箱   【显式的】

        int b2 = a2.intValue();
        double d2 = a2.doubleValue();


    }
    public static void main1(String[] args) {
        String str = "123";
        int ret = Integer.valueOf(str);
        System.out.println(ret + 1);
    }
}
