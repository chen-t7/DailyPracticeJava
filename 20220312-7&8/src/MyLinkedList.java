import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -03 -14
 * Time: 22:58
 */
class ListNode {
    public int val;
    ListNode next;
    ListNode(int data) {
        this.val = data;
    }
}

public class MyLinkedList {
    ListNode head;

    //头插法
    public void addFirst(int data) {
        ListNode cur = new ListNode(data);
        cur.next = this.head;
        this.head = cur;
    }

    //尾插法
    public void addLast(int data) {
        ListNode code = new ListNode(data);
        ListNode cur = this.head;
        if (cur == null) {
            this.head = code;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = code;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if (index < 0 || index > this.size()) {
            System.out.println("非法位置");
            return;
        }
        if (index == 0) {
            this.addFirst(data);
            return;
        }
        if(index == this.size()) {
            addLast(data);
            return;
        }
        ListNode cur = this.findIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    //寻找index-1位置的节点地址
    public ListNode findIndex(int index) {
        ListNode node = this.head;
        while (index-1 != 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
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
            return ;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return ;
        }
        ListNode cur = this.searchPrev(key);
        if (cur == null) {
            System.out.println("没找到你要删除的节点");
            return ;
        }
        ListNode del = cur.next;
        cur.next = del.next;
    }

    //找到要删除关键字的前驱节点
    public ListNode searchPrev(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            System.out.println("该链表为空!");
            return ;
        }
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        //头节点最后再删
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "-> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        //比较粗暴的做法
        //this.head = null;
        while (this.head != null) {
            ListNode curNext = this.head.next;
            this.head = null;
            this.head = curNext;
        }
    }

    //翻转单链表
    public ListNode reverseList() {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode cur = head.next;
        newHead.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curNext;
        }
        return newHead;
    }
}
