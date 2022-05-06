import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -05
 * Time: 17:45
 */
public class TestDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "abcde";
        Class<?> c1 = String.class;
        // 获取 String 类中的 value 字段. 这个 value 和 String 源码中的 value 是匹配的.
        Field valueField = c1.getDeclaredField("value");
        // 将这个字段的访问属性设为 true
        valueField.setAccessible(true);
        // 把 str 中的 value 属性获取到.
        char[] value = (char[]) valueField.get(str);
        // 修改 value 的值
        value[0] = 'h';
        System.out.println(str);

    }

    public static void main10(String[] args) {
        //这种写法会产生大量的临时对象,浪费空间
        String str = "abcde";
        for (int i = 0; i < 10; i++) {
            str += i;
        }
        System.out.println(str);
    }

    public static void func2(String s) {
        /*
        错误写法，有可能s为空会空指针异常，建议下面的写法
        if (s.length() == 0 || s == null) {

        }
         */
        /*
        建议下面的写
        if (s == null || s.length() == 0) {

        }
         */
        assert s != null;//也可用断言判空，但是使用概率较低
    }

    public static void main9(String[] args) {
        //数组的整体赋值只有一次机会，就是在定义的时候
        int[] array = {1,2,3,4,5};
        //array = {4,5,6,7};//编译错误，不能修改指向的对象的值，但是可以修改指向的对象
        array = new int[]{4,5,6,7};

        String str1 = null;//str1不指向任何对象
        String str2 = "";//str2指向的字符串是空的
    }

    public static void main8(String[] args) {
        String str1 = "11";//通过反射进行修改
        String str2 = null;
        /*
        System.out.println(str1.equals("11"));
        System.out.println(str2.equals("11"));//会出现空指针异常
         */
        System.out.println("11".equals(str1));
        System.out.println("11".equals(str2));

    }

    public static void main7(String[] args) {
        String str2 = new String("1") + new String("1");
        str2.intern();//手动把字符串放入常量池，如常量池没有该字符串则入池，有则不入池
        String str1 = "11";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }

    public static void main6(String[] args) {
        String str1 = "hello";
        String str2 = "he" + "llo";//在编译时就已经确定好了是hello
        String str3 = "he";
        String str4 = str3 + "llo";//此时str3是一个变量，编译的时候不知道str3的内容是什么
        System.out.println(str1 == str2);
        System.out.println(str1 == str4);
    }

    public static void main5(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);
    }

    public static void main4(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);
    }

    public static void func(String s, char[] array) {
        s = "chen";
        array[0] = 'p';
    }

    public static void main3(String[] args) {
        String str = "abcdef";
        char[] chars = {'b', 'c', 'd'};
        func(str, chars);
        System.out.println(str);
        System.out.println(chars);
    }

    public static void main2(String[] args) {
        String str1 = "abcdef";
        String str2 = str1;
        System.out.println(str1);
        System.out.println(str2);

        System.out.println("=================");
        str1 = "hello";
        //无法通过str1和str2修改"abcdef”->"gxsja"，因为"abcdef”是常量，只能改变引用的指向
        System.out.println(str1);
        System.out.println(str2);

    }

    public static void main1(String[] args) {
        String str = "abcdef";
        //调用构造方法进行构造对象

        String str2 = new String("hello");

        char[] chars = {'a', 'b', 'c'};
        String str3 = new String(chars);
        System.out.println(str3);
    }
}
