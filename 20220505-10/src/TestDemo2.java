/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -11
 * Time: 17:08
 */
public class TestDemo2 {
    /**
     * StringBuffer或者StringBuilder-->String
     * 调用toString
     * @return
     */
    public static String func2() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.toString();
    }

    /**
     * String-->StringBuffer或者StringBuilder
     * 使用构造方法
     * @return
     */
    public static StringBuffer func() {
        String str = "abcdef";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer;
        //return new StringBuffer(str);
    }

    public static void main5(String[] args) {
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abcdefg");
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder();

        StringBuffer stringBuffer = new StringBuffer();

        String str = new String("abcdef");
    }

    public static void main3(String[] args) {
        String str = "abcdef";
        for (int i = 0; i < 10; i++) {
            //str += i;
            //上面一行代码相当于底层如下代码，产生大量临时对象
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(i);
            str = stringBuilder.toString();
        }
        System.out.println(str);
    }

    public static void main2(String[] args) {
        //String str = "abcdef";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcdef");
        //str += "123";
        stringBuilder.append("123");
        //System.out.println(str);
        System.out.println(stringBuilder.toString());
    }

    public static void main1(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abcdef");
        System.out.println(stringBuilder);//返回的还是同一个对象

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("abcdef");
        stringBuilder2.append("123456").append("000000");
        System.out.println(stringBuilder2.toString());

    }
}
