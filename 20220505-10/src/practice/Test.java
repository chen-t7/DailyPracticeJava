package practice;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -08 -14
 * Time: 22:29
 */


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Test {
    /*
    牛客：链表内指定区间反转
    将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度O(n)，空间复杂度O(1)
    例如输入：{1,2,3,4,5},2,4  预期输出：{1,4,3,2,5}
    输入：{5},1,1   输出：{5}
    输入：{1,2,3},1,2    输出：{2,1,3}
    输入：{1,2,3},2,3    输出：{1,3,2}
    */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }
        ListNode cur = head;
        ListNode curprev = head;
        int count = 1;
        Stack<ListNode> stack = new Stack<>();
        while (count < m && (cur != null)) {
            ++count;
            curprev = cur;
            cur = cur.next;
        }
        ListNode tmp = cur;
        while (count <= n && tmp != null) {
            count++;
            stack.push(tmp);
            tmp = tmp.next;
        }
        int size = stack.size();
        while (!stack.isEmpty()) {
            if (cur == head && size == stack.size()) {
                curprev = stack.pop();
                head = curprev;
            } else {
                curprev.next = stack.pop();
                curprev = curprev.next;
            }
        }
        curprev.next = tmp;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp1 = new ListNode(2);
        ListNode tmp2 = new ListNode(3);
        //ListNode tmp3 = new ListNode(4);
        //ListNode tmp4 = new ListNode(5);
        head.next = tmp1;
        tmp1.next = tmp2;
        tmp2.next = null;
        //tmp3.next = tmp4;
        //tmp3.next = null;
        ListNode newhead = reverseBetween(head,2,3);
        while (newhead != null) {
            System.out.println(newhead.val);
            newhead = newhead.next;
        }
    }
}
