import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -03 -13
 * Time: 16:20
 */
public class MyArrayList {
    public int[] elem;
    public int usedSize;

    MyArrayList() {
        this.elem = new int[10];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < usedSize; ++i) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("请输入正确的位置");
            return;
        }
        if (this.isFull() == true) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        for (int i = usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }

    public boolean isFull() {
        //return this.usedSize == this.elem.length;
        if (this.usedSize == this.elem.length) {
            return true;
        } else {
            return false;
        }
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (this.isEmpty()) {
            System.out.println("顺序表为空");
            return -1;
        }
        if (pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return -1;//业务上的处理，这里不考虑
        }
        return this.elem[pos];
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (this.isEmpty()) {
            System.out.println("顺序表为空");
            return;
        }
        if (pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if (this.isEmpty()) {
            System.out.println("顺序表为空");
            return;
        }
        int pos = this.search(toRemove);
        if(pos == -1) {
            System.out.println("没有你要删除的数字");
            return;
        }else {
            for (int i = pos; i < this.usedSize - 1; i++) {
                this.elem[i] = this.elem[i + 1];
            }
        }
        this.usedSize--;
        //this.elem[toRemove] = null; //如果 数组里面的是复杂类型（引用），还需将被删除的位置置为空
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
        /*
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }
         */
    }

    public boolean isEmpty() {
        return usedSize == 0 ? true : false;
    }
}