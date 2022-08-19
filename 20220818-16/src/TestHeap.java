import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -18
 * Time: 22:12
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    /**
     * 向下函数的实现
     * @param parent  每棵树的根节点
     * @param len      每棵树的调整的结束位置
     */
    public void shiftDown(int parent, int len) {
        int leftChild = 2*parent + 1;
        //进入循环，说明至少有一个孩子
        while (leftChild < len) {
            int rightChild = 2*parent + 2;
            int max = leftChild;
            if (rightChild < len) {
                if (elem[leftChild] < elem[rightChild]) {
                    max = rightChild;
                }
            }

            if (elem[max] <= elem[parent]) {
                break;
            }

            int temp = elem[parent];
            elem[parent] = elem[max];
            elem[max] = temp;

            parent = max;
            leftChild = 2*parent + 1;
        }
    }

    public void createBigHead(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }

        for (int parent = (this.usedSize-1-1)/2; parent >= 0; parent--) {
            //向下调整
            this.shiftDown(parent, this.usedSize);
        }
    }

    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        int len = this.usedSize;
        while (parent >= 0) {
            if (this.elem[parent] >= this.elem[child]) {
                break;
            }

            int temp = this.elem[parent];
            this.elem[parent] = this.elem[child];
            this.elem[child] = temp;

            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public void offer(int val) {
        if (this.isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        elem[usedSize++] = val;
        shiftUp(this.usedSize-1);
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    public int poll() {
        //1.交换0下标和最后一个元素
        //2.只有0下标的这棵树不是大根堆/小根堆，所以调整0下标的这棵树就可
        if (isEmpty()) {
            throw new RuntimeException("优先级队列为空！");
        }
        int temp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        //this.elem[this.usedSize-1] = temp;
        this.usedSize--;

        shiftDown(0, this.usedSize);
        return temp;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("优先级队列为空！");
        }
        return this.elem[0];
    }
}
