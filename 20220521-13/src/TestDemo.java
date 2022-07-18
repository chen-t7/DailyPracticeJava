/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -21
 * Time: 13:21
 */

import java.util.ArrayList;

/**
 * 问题：
 * 1.该类只能存放整数类型的数据，不通用
 *
 * 目标：
 * 1.能不能可以放所有类型--->
 *      方法一：private Object[] elem2;
 *          导致：1.存放元素时不能指定元素，可能会导致每次放的类型不一样，同时可以存放int,String等
 *              2.每次取出数据都需要进行强制类型转换
 *                  引出问题：1.能不能指定这个顺序表的类型？
 *                          2.指定类型之后，是不是就是能放指定类型的数据呢？
 *                          3.取出数据能不能不要进行转换？
 */
class MyArrayList1 {
    //private int[] elem;
    private Object[] elem;
    private int userSize;

    public MyArrayList1() {
        this.elem = new Object[10];
    }

    public void add(Object val) {
        this.elem[userSize] = val;
        userSize++;
    }

    public Object get(int pos) {
        return this.elem[pos];
    }
}

/**
 *
 * @param <E> 代表当前类是一个泛型类，此时的E就是一个占位符而已
 */
class MyArrayList2<E> {
    private E[] elem;
    private int userSize;

    public MyArrayList2() {
        this.elem = (E[])new Object[10];
        //this.elem = new E[10];
    }

    public void add(E val) {
        this.elem[userSize] = val;
        userSize++;
    }

    public E get(int pos) {
        return this.elem[pos];
    }

    /*
    public T[] getArray(int size) {
        T[] genericArray = new T[size];
        return genericArray;
    }
     */

    public Object[] getArray(int size) {
        Object[] genericArray = new Object[size];
        return genericArray;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        String[] strings = new String[10];
        Object[] objects = new String[10];
    }

    public static void main5(String[] args) {
        MyArrayList2<String> myArrayList2 = new MyArrayList2<>();
        //String[] rets = (String[])myArrayList2.getArray(10);

    }

    public static void main4(String[] args) {
        MyArrayList2<String> myArrayList1 = new MyArrayList2<>();
        System.out.println(myArrayList1);
        MyArrayList2<Integer> myArrayList2 = new MyArrayList2<>();
        System.out.println(myArrayList2);
        MyArrayList2<Boolean> myArrayList3 = new MyArrayList2<>();
        System.out.println(myArrayList3);

    }
    public static void main3(String[] args) {
        MyArrayList2<String> myArrayList2 = new MyArrayList2<>();
        myArrayList2.add("abc");
        myArrayList2.add("chen");
        String ret = myArrayList2.get(1);
        System.out.println(ret);

        MyArrayList2<Integer> myArrayList21 = new MyArrayList2<>();
        myArrayList21.add(1);
        myArrayList21.add(121);
        myArrayList21.add(13);
        int ret2 = myArrayList21.get(1);
        System.out.println(ret2);
    }

    public static void main2(String[] args) {
        //泛型，把类型参数化了
        MyArrayList2<String> myArrayList1 = new MyArrayList2<>();
        MyArrayList2<Integer> myArrayList2 = new MyArrayList2<>();
        MyArrayList2<Boolean> myArrayList3 = new MyArrayList2<>();
    }

    public static void main1(String[] args) {
        MyArrayList1 myArrayList = new MyArrayList1();

        myArrayList.add(1);
        myArrayList.add("hello");
        String ret = (String)myArrayList.get(1);
        System.out.println(ret);
    }
}
