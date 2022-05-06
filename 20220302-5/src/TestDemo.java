/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -03 -02
 * Time: 23:14
 */
import java.util.Arrays;

public class TestDemo {
    //java中不规则的二维数组的定义
    public static void main(String[] args) {
        int[][] array = {{1,2}, {4,5,6}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================");
        int[][] array2 = new int[2][];
        array2[0] = new int[3];
        array2[1] = new int[2];
        //array2是不规则的二维数组，两行的列数不一样
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
    }
    //二维数组的打印
    public static void main21(String[] args) {
        int[][] array = {{1,2,3,4}, {5,6,7,8}};
        //System.out.println(array.length);
        //System.out.println(array[0].length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================");
        for (int[] ret:array) {
            for (int x : ret) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println("==================");
        System.out.println(Arrays.deepToString(array));
    }
    //二维数组的定义
    public static void main20(String[] args) {
        int[][] array = {{1,2,3}, {4,5,6}};
        int[][] array2 = new int[][]{{1,2,3}, {4,5,6}};
        int[][] array3 = new int[2][3];
    }
    //拷贝数组
    public static int[] copyArray1(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static void main19(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = copyArray1(array);
        System.out.println(Arrays.toString(ret));
        int[] ret2 = Arrays.copyOf(array, array.length*2);
        System.out.println(Arrays.toString(ret2));
        int[] ret3 = Arrays.copyOfRange(array,1,3);
        System.out.println(Arrays.toString(ret3));
        int[] ret4 = new int[array.length*2];
        System.arraycopy(array,0,ret4,0,array.length);
        System.out.println(Arrays.toString(ret4));
        int[] ret5 = array.clone();
        System.out.println(Arrays.toString(ret5));
    }

    //给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分
    public static void func(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (i < j && array[i] % 2 == 0) {
                i++;
            }
            while (i < j && array[j] % 2 != 0) {
                j--;
            }
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public static void main18(String[] args) {
        int[] array = {1,2,3,4,5,7,9,0,1,2,4,6,7};
        func(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reverse(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main17(String[] args) {
        int[] array = {1,2,3,4,5};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main16(String[] args) {
        int[] array = new int[10];
        //将该数组下标2至6的值填充为1999
        Arrays.fill(array,2,6,1999);
        System.out.println(Arrays.toString(array));
    }

    //冒泡排序
    //给定一个数组, 让数组升序 (降序) 排序.
    //每次尝试找到当前待排序区间中最小(或最大)的元素, 放到数组最前面(或最后面).
    public static void bubbleSort(int[] array) {
        //i表示趟数，数组中如果有3个数，只用比较两次，所以边界是i < array.length - 1
        for (int i = 0; i < array.length - 1; i++) {
            //change标记这一趟是否有交换，如果没有交换代表已经有序，直接break
            boolean change = true;
            //j表示下标，j < array.length - i - 1代表：第一趟已经把最大的数排序到最后，第二趟找到第二大的排到倒数第二
            //后面的下标已经排序完成就不需要比较了，所以是j < array.length - i
            //又因为array[j + 1]，因为数组下标不能越界，所以array.length - i - 1
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    change = false;
                }
            }
            if (change == true) {
                break;
            }
        }
    }

    public static void main15(String[] args) {
        int[] array = {5,2,9,0,1,2,7};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 给定一个整型数组, 判断是否该数组是有序的(升序)
     * @param array
     * @return
     */
    public static boolean isUp(int[] array) {
        boolean ret = true;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1 && array[i] > array[i+1]) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static void main14(String[] args) {
        int[] array = {1,2,3,4,9,7};
        boolean ret = isUp(array);
        System.out.println(ret);
    }
    /**
     * 二分查找，前提是数组必须是有序数组，以下代码为数组是从小到大排
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid + 1;
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main13(String[] args) {
        int[] array = {2,3,4,7};
        System.out.println(binarySearch(array, 14));
        System.out.println(Arrays.binarySearch(array, 14));
    }
    /**
     * 查找数组中指定元素(顺序查找)
     * @param array
     * @param key
     * @return
     */
    public static int getFind(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main12(String[] args) {
        int[] array = {2,3,5,4,7};
        System.out.println(getFind(array, 4));
    }
    /**
     * 找数组中最大的元素
     * @param array
     * @return
     */
    public static int maxNum(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main11(String[] args) {
        int[] array = {3,8,5,1,2};
        //int max = maxNum(array);
        //System.out.println(max);
        System.out.println(maxNum(array));
    }
    /**
     * 数组转字符串
     * @param array
     * @return
     */
    public static String myToString(int[] array) {
        if (array == null) {
            return "null";
        }
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if (i != array.length - 1) {
                str += ',';
            }
        }
        str += ']';
        return str;
    }
    public static void main10(String[] args) {
        int[] array = null;
        System.out.println(myToString(array));
    }

    /**
     * 在原来的数组上扩大了2倍
     * @param array
     */
    public static void transform1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * array[i];
        }
    }

    public static int[] transform2(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i] * 2;
        }
        return ret;
    }

    public static void main9(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        array = transform2(array);
        System.out.println(Arrays.toString(array));
        transform1(array);
        System.out.println(Arrays.toString(array));
    }
    public static void swap(int[] array) {
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }
    public static void main8(String[] args) {
        int[] array = {10, 20};
        System.out.println("交换前：" + array[0] + " " + array[1]);
        swap(array);
        System.out.println("交换后：" + array[0] + " " + array[1]);
    }
    public static void main7(String[] args) {
        int[] array1 = {1,2,3,4,5};
        //int[] array2 = array1;
        array1 = new int[10];
        array1 = new int[2];
        array1 = new int[5];
    }
    public  static void func1(int[] array) {
       array = new int[]{11,2,13,4,51,61};
    }
    public  static void func2(int[] array) {
        array[0] = 899;
    }
    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(array));
        func1(array);
        //func2(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main5(String[] args) {
        int[] array = {1,2,3,4,5};
        printf(array);
    }
    public static void printf(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main4(String[] args) {
        int[] array = null;//这个引用不指向任何对象
        System.out.println(array.length);
    }
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //for each循环，也叫增强for循环
        for(int x :array) {
            System.out.print(x + " ");
        }
        System.out.println();

        //借助java操作数组的工具类 Arrays.toString :将参数的数组以字符串形式打印
        //String ret = Arrays.toString(array);
        //System.out.println(ret);
        System.out.println(Arrays.toString(array));
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(array.length);
        System.out.println(array[3]);
        array[3] = 19;
        System.out.println(array[3]);
    }
    //数组定义的三种方式
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5}; //虽然没写new，array也是一个对象
        // array2并没有初始化，所以里面都是0
        int[] array2 = new int[3];//new关键字：作用：实例化一个对象意味着：Java当中的数组也是一个对象
        int[] array3 = new int[]{1,2,3,4,5};
    }

}
