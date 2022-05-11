import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -05
 * Time: 17:45
 */
public class TestDemo {


    public static void main(String[] args) {
        String str = "          abc   defg       ";
        String ret = str.trim();//去除str两边的空格
        System.out.println(ret);
        System.out.println("==========");

        String str2 = "abcdEFG哈哈哈&*%%";
        String ret2 = str2.toUpperCase();
        System.out.println(ret2);
        System.out.println(str2.toLowerCase());
        System.out.println("==========");

        String str3 = "abcdef";
        String ret3 =  str3.concat("hhhhhhh");
        System.out.println(ret3);
        System.out.println("==========");

        System.out.println(str.length());//区分和数组的length，一个是属性，一个是方法
        int[] array = {1,2,3,4,5};
        System.out.println(array.length);//Java里的数字 非常特殊 机制很多
        System.out.println("==========");

        String str4 = "   ";
        System.out.println(str4.isEmpty());

    }

    public static void main20(String[] args) {
        String str = "abcd";
        String sub = str.substring(2);//提取子串
        System.out.println(sub);
        String sub2 = str.substring(1,2);
        System.out.println(sub2);
    }

    public static void main19(String[] args) {
        String str = "192.168.1.1";
        String[] strings =  str.split("\\.");
        for (String s: strings) {
            System.out.println(s);
        }

        String[] strings2 =  str.split("\\.", 2);
        for (String s: strings2) {
            System.out.println(s);
        }
        System.out.println("============");

        String str2 = "192\\168\\1\\1";
        String[] strings3 =  str2.split("\\\\", 7);
        for (String s: strings3) {
            System.out.println(s);
        }
        System.out.println("============");

        String str3 = "Java30 12&21#hello";
        String[] strings4 = str3.split(" |&|#");
        for (String s: strings4) {
            System.out.println(s);
        }
    }

    public static void main18(String[] args) {
        String str = "name=zhangsan&age=12";
        String[] strings = str.split("&");
        for (String s:strings) {
            String[] ss = s.split("=");
            for (String tmp:ss) {
                System.out.println(tmp);
            }
        }
    }

    public static void main17(String[] args) {
        String str = "abcdabcd";
        //把str中所有的字符a替换成字符t
        String s = str.replace('a', 't');
        System.out.println(s);
        System.out.println("========");

        String s2 = str.replace("ab", "pp");
        System.out.println(s2);
        System.out.println("========");

        String s3 = str.replaceAll("ab", "pp");
        System.out.println(s3);
        System.out.println("========");

        String s4 = str.replaceFirst("ab", "pp");
        System.out.println(s4);
        System.out.println("========");
    }

    public static void main16(String[] args) {
        String str = "abcdabcd";
        String tmp = "abc";
        boolean flg = str.contains(tmp);
        System.out.println(flg);
        System.out.println("========");

        int index = str.indexOf(tmp);
        System.out.println(index);
        int index2 = str.indexOf(tmp, 3);
        System.out.println(index2);
        System.out.println("========");

        int index3 = str.lastIndexOf(tmp);
        System.out.println(index3);
        System.out.println(str.lastIndexOf(tmp, 3));
        System.out.println("========");

        System.out.println(str.startsWith("a"));
        System.out.println(str.startsWith("d"));
        System.out.println(str.startsWith("d", 3));
        System.out.println(str.endsWith("cd"));
        System.out.println(str.endsWith("cde"));
    }

    public static void main15(String[] args) {
        //比较
        String str1 = "abcdef";
        String str2 = "hello";
        System.out.println(str1.equals(str2));
        System.out.println("========================");

        String str3 = "Adc";
        String str4 = "adc";
        System.out.println(str3.equalsIgnoreCase(str4));

        int ret = str3.compareTo(str4);//返回值： >0(str3字符串大于str4)  <0  ==0
        System.out.println(ret);
    }

    public static void main14(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97,98,99,100};//把这些数字转换为该数字对应的阿斯克码
        String str = new String(bytes);
        System.out.println(str);

        String str2 = new String(bytes,1,3);
        System.out.println(str2);

        String str3 = "陈";
        byte[] bytes1 = str3.getBytes();
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str3.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));
    }

    public static boolean IsNumChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            /*
            if (c < '0' || c > '9') {
                return false;
            }
             */
            if (Character.isDigit(c) == false) {
                return false;
            }
        }
        return true;
    }

    public static void main13(String[] args) {
        String str = "123s45";
        System.out.println(IsNumChar(str));
    }

    public static void main12(String[] args) {
        char[] val = {'a', 'b', 'c', 'd', 'e', 'f'};
        String str = new String(val);
        System.out.println(str);

        String str2 = new String(val, 1, 3);
        System.out.println(str2);
        System.out.println("==============");

        String str3 = "hello";
        char ch =  str3.charAt(2);//获取到2下标的字符
        System.out.println(ch);

        char[] chars =  str3.toCharArray();//把str3指向的字符串对象变成字符数组
        System.out.println(Arrays.toString(chars));


    }

    public static void main11(String[] args) throws NoSuchFieldException, IllegalAccessException {
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
