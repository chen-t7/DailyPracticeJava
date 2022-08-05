import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -01
 * Time: 22:55
 */
class TreeNode{
    public char val;
    public TreeNode left;//左孩子的引用
    public TreeNode right;//右孩子的引用
    public TreeNode(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    public TreeNode root;//二叉树的跟根节点

    public TreeNode creatNode() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    //前序遍历
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //后序遍历
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public List<Character> preorderTraversal(TreeNode root) {
        List<Character> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }
        retList.add(root.val);
        List<Character> leftTree = preorderTraversal(root.left);
        retList.addAll(leftTree);
        List<Character> rightTree = preorderTraversal(root.right);
        retList.addAll(rightTree);
        return retList;
    }

    public List<Character> inorderTraversal(TreeNode root) {
        List<Character> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }
        List<Character> leftTree = inorderTraversal(root.left);
        retList.addAll(leftTree);
        retList.add(root.val);
        List<Character> rightTree = inorderTraversal(root.right);
        retList.addAll(rightTree);
        return retList;
    }

    public List<Character> postorderTraversal(TreeNode root) {
        List<Character> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }
        List<Character> leftTree = postorderTraversal(root.left);
        retList.addAll(leftTree);
        List<Character> rightTree = postorderTraversal(root.right);
        retList.addAll(rightTree);
        retList.add(root.val);
        return retList;
    }

    // 遍历思路-求结点个数
    static int size = 0;
    int getSize1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
        return size;
    }

    // 子问题思路-求结点个数
    int getSize2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            //当前为叶子结点
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(TreeNode root, int k) {
        if (root == null|| k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k-1) + getKLevelSize(root.right, k-1);
    }



    /**
     * 获取二叉树的高度
     * 时间复杂度  O(N)
     * 空间复杂度  O(log2(N))
     * @param root
     * @return
     */
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        //整棵树的高度 = 左树的高度 和 右树的高度取最大值 加1 (这里的1是根节点的高度)
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        //不要直接这样return，递归调用的次数太多，会超出时间限制，重复计算了太多次
        //return getHeight(root.left) > getHeight(root.right) ? getHeight(root.left) + 1 : getHeight(root.right) + 1;
    }


    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftNode = find(root.left,val);
        TreeNode rightNode = find(root.right,val);
        return leftNode == null ? rightNode : leftNode;
    }

    /**
     * 判断这棵树是不是完全二叉树
     * @param root
     * @return
     */
    boolean isCompleteTree (TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /*
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null){
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                break;
            }
        }
         */
        while (queue.peek() != null) {
            TreeNode cur = queue.peek();
            queue.offer(cur.left);
            queue.offer(cur.right);
            queue.poll();
        }
         while (!queue.isEmpty()) {
             if (queue.poll() != null) {
                return false;
             }
         }
        return true;
    }

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
