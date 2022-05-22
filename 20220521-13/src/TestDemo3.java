import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -22
 * Time: 21:56
 */
public class TestDemo3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("chen");
        arrayList.add("hahaha");
        System.out.println(arrayList);
        System.out.println("================");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
        System.out.println("================");
        for (String str: arrayList) {
            System.out.print(str + " ");
        }
        System.out.println();
        System.out.println("=====迭代器打印====");
        Iterator<String> it =  arrayList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("=====迭代器List相关打印====");
        ListIterator<String> it2 = arrayList.listIterator();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }

    }

    public static void main1(String[] args) {
        List<String> list = new ArrayList<>(20);//这种写法更通用

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("chen");
        arrayList.add("hahaha");

        //使用另外一个attayList对arrayList1进行初始化
        ArrayList<String> arrayList1 = new ArrayList<>(arrayList);

    }
}
