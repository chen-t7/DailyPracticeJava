import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -20
 * Time: 19:38
 */
public class TopK {
    /**
     * 求数组中topK个元素
     * 求数组当中的前K个最小的元素
     * @param array
     * @param k
     * @return
     */
    public static int[] topK(int[] array, int k) {
        //1.创建一个大小为K的大根堆
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //2.遍历数组当中的元素，前K个元素放入队列中
        for (int i = 0; i < array.length; i++) {
            if (maxheap.size() < k) {
                maxheap.offer(array[i]);
            } else {
                //3.从第K+1个元素开始，每个元素与堆顶元素进行比较
                if (array[i] < maxheap.peek()) {
                    //3.1先弹出
                    maxheap.poll();
                    //3.2后存入
                    maxheap.offer(array[i]);
                }
            }
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = maxheap.poll();
        }
        return temp;
    }

    public static void main1(String[] args) {
        int[] array = {18,21,8,10,34,12};
        int[] tmp = topK(array, 3);
        System.out.println(Arrays.toString(tmp));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)+o2.get(1))-(o1.get(0)+o1.get(1));
            }
        });
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (maxHeap.size() < k) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    maxHeap.offer(list);
                } else {
                    int top = maxHeap.peek().get(0) + maxHeap.peek().get(1);
                    if (top > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        List<Integer> list = new ArrayList<>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        maxHeap.offer(list);
                    }
                }
            }
        }
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            ret.add(maxHeap.poll());
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        List<List<Integer>> tmp = kSmallestPairs(nums1, nums2, k);
        System.out.println(tmp);
    }
}
