import java.util.Arrays;

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
        int ret = this.elem[usedSize];
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
        return this.elem[usedSize];
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "elem=" + Arrays.toString(elem) +
                ", usedSize=" + usedSize +
                '}';
    }
}
