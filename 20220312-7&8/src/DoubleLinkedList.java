/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -03 -24
 * Time: 22:14
 */
class DouListNode {
    public int val;
    DouListNode prev;
    DouListNode next;
    public DouListNode(int val) {
        this.val = val;
    }
}

public class DoubleLinkedList {
    DouListNode head;
    DouListNode tail;

    //头插法
    public void addFirst(int data) {
        DouListNode node = new DouListNode(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        DouListNode node = new DouListNode(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data) {
        DouListNode node = new DouListNode(data);
        if (index < 0 || this.size() < index) {
            System.out.println("位置不合法");
            return false;
        }
        if (index == 0) {
            this.addFirst(data);
            return true;
        }
        if (index == this.size()) {
            this.addLast(data);
            return true;
        }
        DouListNode cur = this.head;
        while (index != 0) {
            index--;
            cur = cur.next;
        }
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
        node.next = cur;
        return true;
    }

    //查找是否包含关键字key
    public boolean contains(int key) {
        DouListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("该链表为空");
            return;
        }
        DouListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = head.next;
                    if (this.head != null) {
                        this.head.prev = null;
                    } else {
                        this.tail = null;
                    }
                } else if (cur == this.tail) {
                    cur.prev.next = cur.next;
                    this.tail = cur.prev;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            System.out.println("该链表为空");
            return;
        }
        DouListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = head.next;
                    if (this.head != null) {
                        this.head.prev = null;
                    } else {
                        this.tail = null;
                    }
                } else if (cur == this.tail) {
                    cur.prev.next = cur.next;
                    this.tail = cur.prev;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }

    //得到链表的长度
    public int size() {
        DouListNode cur = this.head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void display() {
        DouListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        while (this.head != null) {
            DouListNode headNext = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = headNext;
        }
        this.tail = null;
    }
}

