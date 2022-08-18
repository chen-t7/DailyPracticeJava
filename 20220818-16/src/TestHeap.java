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
}
