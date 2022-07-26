import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -07 -18
 * Time: 22:14
 */
public class TestDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }

    public static void main5(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);//默认队尾入队的
        deque.offer(2);
        deque.offerFirst(3);//队头插入
        deque.addLast(4);;
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }

    public static void main4(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        System.out.println(queue.peek());//1
        System.out.println(queue.element());//1
        System.out.println(queue.poll());//1
        System.out.println(queue.remove());//2
    }

    public static void main3(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();
    }

    public static void main2(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println("===================");

        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);

    }

    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        stack.peek();
        System.out.println(stack);
        System.out.println(stack.empty());
        System.out.println("===================");
        System.out.println(stack.isEmpty());

        String s;
    }
}
