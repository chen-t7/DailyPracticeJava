import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -08 -28
 * Time: 13:43
 */
public class TestSmallHeap {
    public int[] elem;
    public int usedSize;

    TestSmallHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public void createSmallHead(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }

        for (int parent = (this.usedSize-1-1)/2; parent >= 0; parent--) {
            shiftDown(parent, this.usedSize);
        }
    }

    public void shiftDown(int parent, int len) {
        int left = parent*2 + 1;
        while (left < len) {
            int right = parent*2 + 2;
            int min = left;
            if (right < len && this.elem[right] < this.elem[left]) {
                min = right;
            }

            if (this.elem[parent] <= this.elem[min]) {
                break;
            }

            int temp = this.elem[parent];
            this.elem[parent] = this.elem[min];
            this.elem[min] = temp;

            parent = min;
            left = parent*2 + 1;
        }
    }

    private void shiftUp(int child) {
        int parent = (child-1)/2;
        int len = this.usedSize;
        while(parent >= 0) {
            if (this.elem[parent] <= this.elem[child]) {
                break;
            }

            int temp = this.elem[parent];
            this.elem[parent] = this.elem[child];
            this.elem[child] = temp;

            child = parent;
            parent = (child-1)/2;
        }
    }

    public void offer(int val) {
        if (this.isFull() == true) {
            this.elem = Arrays.copyOf(elem, this.usedSize*2);
        }
        this.elem[usedSize] = val;
        this.usedSize++;
        this.shiftUp(this.usedSize-1);
    }


    public int poll() {
        if (this.isEmpty() == true) {
            throw new RuntimeException("优先级队列为空");
        }
        int temp = this.elem[0];
        this.elem[0] = this.elem[usedSize-1];
        this.usedSize--;
        shiftDown(0,this.usedSize);
        return temp;
    }

    public boolean isFull() {
        return this.elem.length == this.usedSize;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int peek() {
        if (this.isEmpty() == true) {
            throw new RuntimeException("优先级队列为空");
        }
        return this.elem[0];
    }

    public void heapSort() {
        int end = this.usedSize - 1;
        while (end > 0) {
            int temp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = temp;
            shiftDown(0, end);
            end--;
        }
    }
}
