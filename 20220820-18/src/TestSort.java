import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -20
 * Time: 21:53
 */
public class TestSort {
    /**
     * 排序默认是从小到大排序
     * 插入排序：
     * 时间复杂度：O(N^2) ：逆序的时候（最快的情况下），最好的情况下，数据有序时时间复杂度是O(N)
     *      根据这个结论推导出另一个结论：对于直接插入排序来说，数据越有序，越快
     *      一般情况下，直接插入排序可以用于一些区间比较
     * 空间复杂度：O(1)
     * 稳定性：稳定的，一个稳定的排序可以变成不稳定的排序，但是一个本身不稳定的排序，是变不成稳定的排序的
     * 经常使用在 ：数据量不多，且整体数据趋于有序了
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                // if (array[j] >= tmp) {  //加=就不稳定了
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    //array[j + 1] = tmp;//只要j回退的时候，遇到了比tmp小的元素，直接结束这次比较
                    break;
                }
            }
            //j回退到了<0的地方时
            array[j + 1] = tmp;
        }
    }

    /**
     * @param array  待排序序列
     * @param gap   组数
     */
    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (temp < array[j]) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = temp;
        }
    }

    /**
     * 希尔排序：
     * 时间复杂度【和增量有关系的】O(N^1.3 ~ N^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的
     * @param array
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        shell(array, 1);//保证最后是整体一组进行排序
    }

    /**
     * 选择排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     * 有序的数据
     * @param capacity
     */
    public static void test1(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long start = System.currentTimeMillis();
        //insertSort(array);
        //selectSort(array);
        //shellSort(array);
        heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 无序的数据
     * @param capacity
     */
    public static void test2(int capacity) {
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(capacity);
        }
        long start = System.currentTimeMillis();
        //insertSort(array);
        //selectSort(array);
        //shellSort(array);
        heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main1(String[] args) {
        test1(1_0000);
        test2(1_0000);
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 堆排序：1.建堆  2.交换，调整
     * 时间复杂度：O(N*log N)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     */
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end);
            shiftDown(array, 0, end);
            end--;
        }
    }

    public static void createHeap(int[] array) {
        for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    public static void shiftDown(int[] array, int parent, int len) {
        int child = 2*parent + 1;
        while (child < len) {
            if (child + 1 < len) {
                if (array[child] < array[child+1]) {
                    child++;
                }
            }
            //child下标是左右孩子中最大值的下标
            if (array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {12,5,18,77,31,10,4,2,86,9,7};
        shellSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {12,5,18,77,31,10,4,2,86,9,7};
        insertSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {12,5,18,77,31,10,4,2,86,9,7};
        selectSort(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {12,5,18,77,31,10,4,2,86,9,7};
        selectSort(array4);
        System.out.println(Arrays.toString(array4));
    }
}
