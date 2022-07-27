/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -07 -27
 * Time: 21:43
 */
public class MyCircularQueue {
    public int[] elem;
    public int front;//队头
    public int rear;//队尾

    public MyCircularQueue(int k) {
        this.elem = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        //rear++;错误写法，转一圈回来以后下标要清零
        this.rear = (this.rear + 1) % elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % elem.length;
        return true;
    }

    //得到队头元素
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }

    //得到队尾元素
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        //队尾下标为0时，rear - 1是负数，没法取到
        return this.elem[(rear - 1 + elem.length) % elem.length];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        if ((rear + 1) % elem.length == front) {
            return true;
        }
        return false;
    }
}
