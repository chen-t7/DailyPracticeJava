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
        Integer a3 = new Integer(123);

        int b2 = a2.intValue();//拆箱   【显式的】

        Double d = 2.3;
        double d2 = d;
        System.out.println(d);
        System.out.println(d2);
        System.out.println("=================");

        Double d3 = Double.valueOf(6.66);
        Double d4 = new Double(7.77);

        double d5 = d3.doubleValue();

        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
    }
    public static void main1(String[] args) {
        String str = "123";
        int ret = Integer.valueOf(str);
        System.out.println(ret + 1);
    }
}
