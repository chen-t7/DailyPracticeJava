import java.util.Arrays;

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
     * 时间复杂度：O(N^2)  最好的情况下，数据有序时时间复杂度是O(N)
     *      根据这个结论推导出另一个结论：对于直接插入排序来说，数据越有序，越快
     *      一般情况下，直接插入排序可以用于一些区间比较
     * 空间复杂度：O(1)
     * 稳定性：稳定的
     * 一个稳定的排序可以变成不稳定的排序
     * 但是一个本身不稳定的排序，是变不成稳定的排序的
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
    public static void main(String[] args) {
        int[] array = {12,5,18,10,4,2};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
