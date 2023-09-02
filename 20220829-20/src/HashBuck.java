/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -02 -18
 * Time: 19:37
 */
public class HashBuck {

    static class Node {
        public int key;
        public String val;
        public Node next;

        public Node(int key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;
    public static final double DEFAULT_LOADFACTOR = 0.75;

    public HashBuck() {
        this.array = new Node[10];
    }

    /**
     * put函数
     * @param key
     * @param val
     */
    public void put(int key, String val) {
        //1.找到key的位置
        int index = key % this.array.length;
        //2.遍历这个下标的列表，看看是不是有相同的key。有要更新val值。
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;//更新val值
                return ;
            }
            cur = cur.next;
        }
        //3.没有key这个元素(头插法，或者尾插法)
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        //4.插入元素成功后，检查当前散列表的负载因子
        if (loadFactor() > DEFAULT_LOADFACTOR) {
            resize();
        }
    }

    //非常重要的问题
    //如果扩容数组，那么数组里面的每个链表的每个元素都要进行重新哈希
    private void resize() {
        Node[] newArray = new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;//获取新的下标
                Node curNext = cur.next;
                cur.next = newArray[index];//头插法
                newArray[index] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;
    }

    private double loadFactor() {
        return 1.0*this.usedSize/this.array.length;
    }

    /**
     * 根据key下标返回val值
     * @param key
     * @return
     */
    public String get(int key) {
        int index = key % this.array.length;
        Node cur = this.array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,"a");
        hashBuck.put(12,"d");
        hashBuck.put(3,"de");
        hashBuck.put(6,"wdw");
        hashBuck.put(7,"wqd");
        hashBuck.put(2,"qqtd");
        hashBuck.put(11,"qqd");
        hashBuck.put(8,"qq11d");
        System.out.println(hashBuck.get(11));
    }
}

