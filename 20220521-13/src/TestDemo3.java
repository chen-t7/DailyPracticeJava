import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -22
 * Time: 21:56
 */


public class TestDemo3 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();//初始大小的容量？0
        list.add("haha!");//当第一次存放数据元素时，数据表被分配内存大小为10
        ArrayList<String> list2 = new ArrayList<>(13);//初始大小的容量是指定的13
    }

    public static void main5(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("f");
        list2.add("c");//add默认放到数组的最后一个位置
        list2.add("g");
        list2.add("c");

        System.out.println(list2);

        System.out.println(list2.indexOf("c"));
        System.out.println(list2.lastIndexOf("c"));

        List<String> sub =  list2.subList(1,3);
        System.out.println(sub);
        System.out.println(list2);
        System.out.println("==========================");

        sub.set(0, "p");
        System.out.println(sub);//修改了sub中的元素，list2中的元素也随之改变
        System.out.println(list2);
        System.out.println("==========================");


        list2.add(0, "chen");
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("我是测试List");
        list3.add("haha");
        list2.addAll(list3);
        System.out.println(list2);
        System.out.println("==========================");


        String ret =  list2.remove(0);
        System.out.println(list2);

        boolean flg = list2.remove("a");
        System.out.println(flg);

        String ret2 = list2.get(1);
        System.out.println(ret2);
        System.out.println("==========================");


        String ret3 = list2.set(2, "chen");
        System.out.println("原来的字符串" + ret3);
        System.out.println(list2);

        boolean flg2 = list2.contains("chen");
        System.out.println(flg2);

        list2.clear();
        System.out.println(list2);
        System.out.println("==========================");

    }

    public static void main4(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("chen");
        arrayList.add("hahaha");
        //CopyOnWriteArrayList它是ArrayList的线程安全的变体
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();
        list2.add("hello");
        list2.add("chen");
        list2.add("hahaha");

        //没有add方法
        Iterator<String> it =  arrayList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("=====迭代器List相关打印====");
        /*
        ListIterator<String> it2 = arrayList.listIterator();
        while (it2.hasNext()) {
            String ret = it2.next();
            if (ret.equals("hello")) {
                arrayList.add("chenyu");  //会抛出异常，因为ArrayList是线程不安全的
            } else {
                System.out.print(ret + " ");
            }
        }
        System.out.println("=======================");
         */
        ListIterator<String> it3 = list2.listIterator();
        while (it3.hasNext()) {
            String str = it3.next();
            if (str.equals("hello")) {
                list2.add("chenyu");
            } else {
                System.out.print(str + " ");
            }
        }
        System.out.println();
    }

    public static void main3(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("chen");
        arrayList.add("hahaha");
        Iterator<String> it =  arrayList.iterator();
        while (it.hasNext()) {
            String ret = it.next();
            if (ret.equals("hello")) {
                it.remove();//首先需要使用next方法迭代出集合的元素，然后才能调用remove
            } else {
                System.out.print(ret + " ");
            }
        }
        System.out.println();
        System.out.println("================");
        ListIterator<String> it2 = arrayList.listIterator();
        while (it2.hasNext()) {
            String ret = it2.next();
            if (ret.equals("hahaha")) {
                it2.remove();//首先需要使用next方法迭代出集合的元素，然后才能调用remove
            } else {
                System.out.print(ret + " ");
            }
        }
    }

    public static void main2(String[] args) {
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
        for (String str:arrayList) {
            System.out.print(str + " ");
        }
        System.out.println();
        System.out.println("=====迭代器打印====");
        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
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
        System.out.println(arrayList1);
    }
}
