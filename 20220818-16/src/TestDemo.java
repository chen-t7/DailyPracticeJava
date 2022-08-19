import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -18
 * Time: 21:18
 */
public class TestDemo {
    public static void main1(String[] args) {
        //默认是小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //offer每放一个元素都得保证当前的堆是大堆 或者小堆
        priorityQueue.offer(12);
        priorityQueue.offer(3);
        priorityQueue.offer(15);

        System.out.println(priorityQueue.peek());
        //poll每弹出一个元素仍得保证当前的堆是大堆 或者小堆
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void main(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        TestHeap testHeap = new TestHeap();
        testHeap.createBigHead(array);
        testHeap.offer(80);
        System.out.println("=============");

        System.out.println(testHeap.poll());
        System.out.println(testHeap.poll());
    }
}
