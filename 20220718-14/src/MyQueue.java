/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -07 -26
 * Time: 22:33
 */
class Node {
    public int val;
    public Node next;
    public Node (int val) {
        this.val = val;
    }
}

public class MyQueue {
    public Node head;
    public Node last;

    /**
     * 出队
     * @param val
     */
    public void offer(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            last.next = node;
            this.last = last.next;
        }
    }

    /**
     * 入队
     * @return
     */
    public int poll() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int oldVal = head.val;
        this.head = head.next;
        return oldVal;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return head.val;
    }
}
