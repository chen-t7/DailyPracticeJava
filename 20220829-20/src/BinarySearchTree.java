/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -02 -13
 * Time: 22:01
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node (int val) {
        this.val = val;
    }
}
public class BinarySearchTree {
    public Node root = null;

    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.val) {
                cur = cur.left;
            } else if (key == cur.val) {
                return cur;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public boolean insert(int val) {
        if (root == null) {
            this.root = new Node(val);
            return true;
        }
        Node cur = root;
        Node p = null;
        //1.找到val的插入位置
        while (cur != null) {
            p = cur;
            if (val < cur.val) {
                cur = cur.left;
            } else if (val == cur.val) {
                return false;
            } else {
                cur = cur.right;
            }
        }
        //2.插入val
        Node node = new Node(val);
        if (val < p.val) {
            p.left = node;
        } else {
            p.right = node;
        }
        return true;
    }

    //删除比较复杂，多看
    public boolean remove(int val) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val == val) {
                removeNode(cur, parent);
                break;
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        return true;
    }

    public Node removeNode(Node cur, Node parent) {
        if (cur.left == null) {
            if (cur == this.root) {
                root =  cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == this.root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            //两种方法
            //1.cur 的左树当中找最大值
            //2.cur 的右树当中找最小值

            Node tp = cur;
            Node t = cur.left;
            while (t.right != null) {
                tp = t;
                t = t.right;
            }
            cur.val = t.val;
            if (t == tp.left) {
                tp.left = t.left;
            } else {
                tp.right = t.left;
            }
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        //int[] array = {10, 8, 19, 3, 9, 4, 7};
        int[] array = {5,3,2,1,0,3,4,7,8,6,9};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println("插入重复数据");
        System.out.println(binarySearchTree.insert(3));

        System.out.println("删除数据：");
        binarySearchTree.remove(3);
        binarySearchTree.inOrder(binarySearchTree.root);
    }
}
