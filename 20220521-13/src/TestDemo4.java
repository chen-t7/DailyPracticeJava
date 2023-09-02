import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.awt.image.IndexColorModel;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -07 -17
 * Time: 21:31
 */

class Student {
    private String name;
    private String classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

class MyArrayList<E> {

    private Object[] elementData;//数组
    private int usedSize;//代表有效的数据个数

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int capacity) {
        //对参数进行判断
        if (capacity > 0) {
            this.elementData = new Object[capacity];
        } else if (capacity == 0) {
            this.elementData = new Object[0];
        } else {
            throw new IllegalArgumentException("初始化的容量不能为负数");
        }
    }

    /**
     * 添加元素,相当于存放在了数组的最后位置
     * @param e 数据
     * @return
     */
    public boolean add(E e) {
        //确定一个真正的容量,预测-->扩容【把检查顺序表空和扩容放到了一起】
        ensureCapacityInternal(usedSize + 1);
        this.elementData[usedSize++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        //1.计算出需要的容量
        int capacity = calculateCapacity(this.elementData, minCapacity);
        //2.拿着计算出的容量去和数组的大小比较，满了扩容，空的分配内存
        ensureExplicitCapacity(capacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        //进不去if语句，说明数组还没有放满
        if (minCapacity - elementData.length > 0) {
            //放满后进行扩容
            grow(minCapacity);
        }
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        //1.先判断elementData数组之前是否分配过的大小;没分配过，比较usedSize+1和10的大小并返回所需容量
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(10, minCapacity);
        }
        //2.分配过，就返回usedSize+1后的值
        return minCapacity;
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//每次扩容1.5倍
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            //说明你要的容量非常大
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public void add(int index, E e) {
        //1.检查下标是否合法
        rangeCheckForAdd(index);
        //2.确定真正的容量
        ensureCapacityInternal(usedSize + 1);
        //3.挪动数据
        copy(index, e);
        this.usedSize++;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("index位置不合法，无法插入");
        }
    }

    /**
     * 获取顺序表的大小
     * @return
     */
    public int size() {
        return this.usedSize;
    }

    private void copy(int index, E e) {
        for (int i = usedSize - 1; i >= index; i--) {
            this.elementData[i+1] = this.elementData[i];
        }
        this.elementData[index] = e;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", usedSize=" + usedSize +
                '}';
    }
}

public class TestDemo4 {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        String str1 = "welcome to beijing!";
        String str2 = "come";
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) {
                list.add(ch);
            }
        }
        for (char ch: list) {
            System.out.print(ch);
        }
    }

    public static void main5(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(2);
        arrayList.add(33);
        //Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }

    public static void main4(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("chen0", "660", 99.20));
        students.add(new Student("chen1", "661", 99.21));
        students.add(new Student("chen2", "662", 99.22));
        students.add(new Student("chen3", "663", 99.23));

        System.out.println(students);
    }

    public static void main3(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("abc");
        List<String> list2 = new ArrayList<>(14);
        //此时list2的方法没有list1的方法多，因为只能调用List自己的方法
    }

    public static void main2(String[] args) {
        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };//匿名内部类
        System.out.println(o.equals("Fred"));
        //o是一个引用，引用了一个匿名内部对象
    }

    public static void main1(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(0, 99);
        myArrayList.add(2,88);
        myArrayList.add(6,77);
        System.out.println(myArrayList);


        MyArrayList<String> myArrayList2 = new MyArrayList<String>(9);
        myArrayList2.add("chen");
        myArrayList2.add("chen1");
        myArrayList2.add("chen2");
        System.out.println(myArrayList2.toString());
    }
}
