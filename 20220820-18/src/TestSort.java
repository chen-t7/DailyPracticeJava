import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

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

    public static void insertSort2(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
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
        //heapSort(array);
        quickSort(array);
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
        //heapSort(array);
        quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main1(String[] args) {
        test1(100_0000);
        test2(100_0000);
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

    /**
     * 冒泡排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 优化的冒泡排序
     * 时间复杂度：最坏的情况下：O(N^2)  最好的情况下：O(N)
     * 空间复杂度：O(1)
     * @param array
     */
    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = false;
                    swap(array, j, j + 1);
                }
            }
            if (flag == true) {
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：最好情况下【每次可以均匀的分割待排序序列】：O(K*N*logn)
     *           最快情况下：数据有序  或者 逆序的情况：O(N^2)
     * 空间复杂度：最好的情况下：O(logn)   最坏：单分支的一棵树
     * 稳定性：不稳定
     * @param array
     */
    public static void quickSort1(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return ;
        }

        //如果区间之内的数据，在排序的过程中，小于某个范围，直接使用插入排序
        if (right - left + 1 <= 140) {
            //使用直接插入排序
            insertSort2(array, left, right);
            return;
        }

        //找基准之前，找到中间大小的值：
        //   几数取中（例如三数取中）：array[left], array[mid], array[right] 大小是中间的为基准值
        int midValIndex = findMidValIndex(array, left, right);
        swap(array, midValIndex, left);

        int pivot = partition(array, left, right);
        quick(array, left, pivot-1);
        quick(array, pivot+1, right);
    }

    private static int findMidValIndex(int[] array, int start, int end) {
        int mid = start + ((end - start) >> 1);
        if (array[start] < array[end]) {
            if (array[mid] < array[start]) {
                return start;
            } else if (array[mid] > array[end]) {
                return end;
            } else {
                return mid;
            }
        } else {
            if (array[mid] > array[start]) {
                return start;
            } else if (array[mid] < array[end]) {
                return end;
            } else {
                return mid;
            }
        }
    }

    //挖坑法
    private static int partition(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] >= tmp) {
                end--;
            }
            //说明end下标的值小于tmp
            array[start] = array[end];
            while (start < end && array[start] <= tmp) {
                start++;
            }
            //start下标遇到了大于tmp的值
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }

    /**
     * 非递归的快排
     * @param array
     */
    public static void quickSort(int[] array) {
        //1.划分之后，把左右的数对都放到栈当中。前提：Pivot左边有2个元素（pivot>left+1）
        //              ，右边有2个元素（pivot<right-1）
        //
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length-1;
        int pivot = partition(array, left, right);
        if (pivot > left + 1) {
            //左边至少有2个元素
            //如果左边只有一个元素，说明只有一个值比pivot小，那么这个值的位置就是有序的
            stack.push(left);
            stack.push(pivot-1);
        }
        if (pivot > right - 1) {
            //右边至少有两个元素
            //如果右边只有一个元素，说明只有一个值比pivot大，那么这个值已经有序了
            stack.push(pivot+1);
            stack.push(right);
        }

        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();

            pivot = partition(array, left, right);
            if (pivot > left + 1) {
                //左边至少有2个元素
                stack.push(left);
                stack.push(pivot-1);
            }
            if (pivot > right - 1) {
                //右边至少有2个元素
                stack.push(pivot+1);
                stack.push(right);
            }
        }
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        if (array1 == null) {
            return array2;
        }
        if (array2 == null) {
            return array1;
        }
        int[] ret = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] <= array2[index2]) {
                ret[i++] = array1[index1++];
            }
            if (array2[index2] <= array1[index1]) {
                ret[i++] = array2[index2++];
            }
        }

        while (index1 < array1.length) {
            ret[i++] = array1[index1++];
        }
        while (index2 < array2.length) {
            ret[i++] = array2[index2++];
        }
        return ret;
    }

    /**
     * 归并排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(N)
     * 稳定性：稳定的排序，如果if (array[index1] <= array[index2]) 不取等号，就是不稳定的
     * @param array
     */
    public static void mergeSort1(int[] array) {
        mergeSortInternal(array, 0, array.length-1);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return ;
        }
        int mid = low + ((high - low) >> 1);

        mergeSortInternal(array, low, mid);
        mergeSortInternal(array,mid+1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] ret = new int[high-low+1];
        int i = 0;
        int index1 = low;
        int e1 = mid;
        int index2 = mid + 1;
        int e2 = high;
        while (index1 <= e1 && index2 <= e2) {
            if (array[index1] <= array[index2]) {
                ret[i++] = array[index1++];
            } else {
                ret[i++] = array[index2++];
            }
        }

        while (index1 <= e1) {
            ret[i++] = array[index1++];
        }
        while (index2 <= e2) {
            ret[i++] = array[index2++];
        }
        for (int j = 0; j < ret.length; j++) {
            array[j+low] = ret[j];
        }
    }

    /**
     * 非递归实现 归并排序
     * @param array
     */
    public static void mergeSort(int[] array) {
        int nums = 1;//每组的数据个数
        while (nums < array.length) {
            //数组每次都要从0开始遍历,确定要归并的区间
            for (int i = 0; i <array.length ; i += nums*2) {
                int left = i;
                int mid = left + nums - 1;
                if (mid >= array.length) {
                    mid = array.length-1;
                }
                int right = mid + nums;
                if (right >= array.length) {
                    right = array.length - 1;
                }
                //下标确定之后，进行合并
                merge(array, left, mid, right);
            }
            nums *= 2;
        }
    }

    /**
     * 计数排序
     *一般适用于 有n个数，数据范围是0~n之间的
     * 时间复杂度：O(N)
     * 空间复杂度：O(M),M代表当前数据的范围
     * 稳定性：当前代码是不稳定的，但是本质是稳定的，可以再借用一个数组标记
     * @param array
     */
    public static void countSort(int[] array) {
        if (array == null) {
            return ;
        }
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        //找到了最大值和最小值
        //如果数据范围是900~999，只需开辟maxVal-minVal+1个空间
        int[] count = new int[maxVal-minVal+1];
        //统计array中，每个数字出现的次数
        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            //为了空间的合理使用，这里需要计数到index-minVal下标
            count[index-minVal]++;
        }
        //说明在计数数组当中，已经把array数组当中每个数据出现的次数已经统计好了
        int indexArray = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                //要放入i + minVal才能还原真正的数值
                array[indexArray++] = i + minVal;
                count[i]--;
            }
        }
    }

    public static void main2(String[] args) {
        int[] array1 = {1,3,6,7,7,8,8,9};
        int[] array2 = {2,3,4,7,8};
        int[] array3 = mergeArray(array1, array2);
        System.out.println(Arrays.toString(array3));
    }

    public static void main(String[] args) {
        int[] array1 = {12,5,18,77,31,5,10,4,2,86,9,7};
        shellSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {12,5,18,77,31,5,10,4,2,86,9,7};
        insertSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {12,5,18,77,31,5,10,4,2,86,9,7};
        selectSort(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {12,5,18,77,31,5,10,4,2,86,9,7};
        selectSort(array4);
        System.out.println(Arrays.toString(array4));

        int[] array5 = {12,5,18,77,31,5,10,4,2,86,9,7};
        bubbleSort2(array5);
        System.out.println(Arrays.toString(array5));

        int[] array6 = {12,5,18,77,31,5,10,4,2,86,9,7};
        quickSort1(array6);
        System.out.println(Arrays.toString(array6));

        int[] array7 = {12,5,18,77,31,5,10,4,2,86,9,7};
        mergeSort(array7);
        System.out.println(Arrays.toString(array7));

        int[] array8 = {12,5,18,77,31,5,10,4,2,86,9,7};
        countSort(array8);
        System.out.println(Arrays.toString(array8));
    }
}
