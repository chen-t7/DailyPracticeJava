import com.sun.javafx.image.impl.ByteIndexed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -25
 * Time: 21:07
 */
class MyArray1 {
    public Object[] objects = new Object[10];

    public void set(int pos, Object val) {
        objects[pos] = val;
    }

    public Object get(int pos) {
        return objects[pos];
    }
}

/**
 *class MyArray<T extends Number>：泛型的上界。  泛型没有下界，如果不指定上界，默认泛型的上界是Object
 * @param <T> 此时代表当前类是一个泛型类，T：当做是一个占位符
 */
//class MyArray<T extends Number> {
class MyArray<T> {
    //public T[] objects = new T[10];//Error:1.不能实例化泛型类型的数组
    public T[] objects = (T[])new Object[10];//也不可以

    public void set(int pos, T val) {
        objects[pos] = val;
    }

    public T get(int pos) {
        return objects[pos];
    }

    //Object[]--->"hello"  10   5.12
    public T[] getArray() {
        return objects;
    }
}

//写一个泛型类，求出数组当中的最大值
//此时传入的T一定要实现这个接口(Comparable)，泛型的上界
class Alg<T extends Comparable<T>> {
    //public <T extends Comparable<T>> T findMax(T[] array) {
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            //if (max < array[i]) { //Error，引用类型不能用<比较
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Alg2 {
    //静态方法不依赖对象，方法不指定T不能识别类型。如果需要比较的话，还需要指定泛型的上界
    public static<T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            //if (max < array[i]) { //Error，引用类型不能用<比较
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Alg3 {
    public static <T> void print1(ArrayList<T> list) {
        for (T x : list) {
            System.out.println(x);
        }
    }

    public static void print2(ArrayList<?> list) {
        for (Object x : list) {
            System.out.println(x);
        }
    }
}
class A {

}
class Person extends A{

}

class Student extends Person {

}

class C extends Student {

}

public class TestDemo {
    public static void main(String[] args) {
        ArrayList<? super Person> arrayList1 = new ArrayList<Person>();
        //ArrayList<? super Person> arrayList2 = new ArrayList<Student>();
        arrayList1.add(new Person());
        arrayList1.add((new Student()));//添加的元素 是Person或者Person的子类
        //arrayList1.add(new A());//error
        arrayList1.add(new C());

        ArrayList<? super Person> arrayList2 = new ArrayList<A>();
        arrayList2.add(new Person());
        arrayList2.add((new Student()));

        //Person person = arrayList2.get(0);//error
        //Student student = arrayList1.get(0);//error
        Object o = arrayList1.get(0);


    }
    public static void main8(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        List<? extends Number> list1 = arrayList1;
        //List<? extends Number> list2 = arrayList2;
        //list1.add(0, 1);//ERROR:通配符的上界，不适合写入数据
        //list1.add(1,10.9);
        Number o = list1.get(0);
        //Integer a = list1.get(1);//Error
    }

    public static void main7(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        Alg3.print2(list1);
    }

    public static void main6(String[] args) {
        Alg<Integer> alg1 = new Alg<>();
        System.out.println(alg1);
        Alg<Integer> alg2 = new Alg<>();
        System.out.println(alg1);

    }

    public static void main5(String[] args) {
        Integer[] array = {1,2,4,74,5};
        System.out.println(Alg2.findMax(array));
        System.out.println(Alg2.<Integer>findMax(array));
    }

    public static void main4(String[] args) {
        Alg<Integer> alg1 = new Alg<>();
        Integer[] array1 = {1,23,4,5};
        System.out.println(alg1.findMax(array1));

        Alg<String> alg2 = new Alg<>();
        String[] array2 = {"ad", "cv", "dge"};
        System.out.println(alg2.findMax(array2));
    }

    public static void main3(String[] args) {
        MyArray<String> myArray = new MyArray<>();
        MyArray<Integer> myArray2 = new MyArray<>();
        MyArray<Number> myArray3 = new MyArray<>();
        //String[] ret = myArray.getArray();Error://编译器认为此时并不是很安全
        Object[] ret2 = myArray.getArray();
        myArray3.set(0, 1);
        myArray3.set(1, 1.1);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        //Integer[] ret3 = arrayList.toArray();//Error
        Object[] ret3 = arrayList.toArray();
    }

    public static void main2(String[] args) {
        MyArray<String> myArray = new MyArray<>();
        myArray.set(0, "hello");
        //myArray.set(1,10); 1.在编译的时候，自动进行类型检查
        String str = myArray.get(0);//2.不需要进行强制类型转换，编译器会自动进行类型转换

        MyArray<Integer> myArray2 = new MyArray<>();
        //MyArray<int> myArray3 = new MyArray<>();//简单类型 基本类型 不能作为泛型类型的参数

        MyArray myArray3 = new MyArray();
        myArray.set(0, "hello");
        //myArray.set(1,10);
        String str3 = (String)myArray.get(0);
    }

    public static void main1(String[] args) {
        MyArray1 myArray = new MyArray1();
        //用Object导致的问题----使用泛型解决
        //1.这个数组什么类型都可以存放
        myArray.set(0, "hello");
        myArray.set(1,10);
        //2.取出的时候必须进行强制类型转换
        String str = (String)myArray.get(0);
    }
}
