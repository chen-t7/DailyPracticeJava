import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -07 -25
 * Time: 21:40
 */
public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[5];
        this.usedSize = 0;
    }

    public void push(int val) {
        if (this.isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        int ret = this.elem[usedSize-1];
        this.elem[usedSize-1] = 0;
        this.usedSize--;
        return ret;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return this.elem[usedSize-1];
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "elem=" + Arrays.toString(elem) +
                ", usedSize=" + usedSize +
                '}';
    }
}

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 */
class MyStack1 {
    public Queue<Integer> queue1;
    public Queue<Integer> queue2;

    public MyStack1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (queue2.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    public int pop() {
        if (this.empty()) {
            return -1;
        }
        if (!queue1.isEmpty()) {
            //如果栈中总共只有一个元素，那么就不插入另一个队列了，直接弹出
            int size = queue1.size();
            for (int i = 0; i < size - 1; ++i) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size - 1; ++i) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public int top() {
        if (this.empty()) {
            return -1;
        }
        int ret = -1;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; ++i) {
                ret = queue1.peek();
                queue2.offer(queue1.poll());
            }
        } else {
            int size = queue2.size();
            for (int i = 0; i < size; ++i) {
                ret = queue2.peek();
                queue1.offer(queue2.poll());
            }
        }
        return ret;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}