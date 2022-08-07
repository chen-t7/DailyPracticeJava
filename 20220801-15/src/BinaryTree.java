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

    /**
     * 穷举的方式创建二叉树
     * @return
     */
    public TreeNode createNode1() {
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

    /*
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(char val) {
            this.val = val;
        }
    }

     */
    public static class Main {
        public static int i = 0;

        /**
         * 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）.
         * 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
         * 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
         * @param str
         * @return
         */
        public static TreeNode createTree(String str) {
            TreeNode root = null;
            if (str.charAt(i) != '#') {
                root = new TreeNode(str.charAt(i));
                i++;
                root.left = createTree(str);
                root.right = createTree(str);
            } else {
                //遇到#号，说明当前节点为空
                i++;
            }
            return root;
        }

        public static void inorder(TreeNode root) {
            if (root == null) {
                return ;
            }
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                String str = in.nextLine();
                TreeNode root = createTree(str);
                inorder(root);
            }
        }
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
     * 时间复杂度：O(min(m,n))
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

    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
     * 如果存在，返回 true ；否则，返回 false 。力扣（LeetCode）
     * 时间复杂度：O(m*n)
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //1.先判断两棵树是不是两颗相同的树
        //2.不是的话判断subRoot是不是root的左子树或者右子树
        if (root == null || subRoot == null) {
             return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        if (isSubtree(root.left, subRoot)){
            return true;
        }
        if (isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    //时间复杂度：O(n)
    public int height (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * 时间复杂度：O(N^2)
     */
    public boolean isBalanced(TreeNode root) {
        //一棵树为平衡二叉树，它的子树也是平衡二叉树
        //1.root左树的高度-右树的高度<=1
        //2.root的左树是平衡树，root的右树也是平衡树
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //时间复杂度：O(n)
    public int height2 (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight >= 0 && rightHeight >= 0 & Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            //进入else说明左树和右树的高度差绝对值超过1，即非平衡二叉树
            return -1;
        }
    }
    /**
     * 方法二：判断一棵树是否为平衡二叉树
     时间复杂度：O(N)
     */
    public boolean isBalanced2(TreeNode root) {
        //一棵树为平衡二叉树，它的子树也是平衡二叉树
        //1.root左树的高度-右树的高度<=1
        //2.root的左树是平衡树，root的右树也是平衡树
        if (root == null) {
            return true;
        }
        return height(root) >= 0;
    }

    public boolean isSymmetricChild(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return isSymmetricChild(leftNode.left, rightNode.right) && isSymmetricChild(leftNode.right, rightNode.left);
    }

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
     * @param root
     */
    public void levelOrder1(TreeNode root) {
        if (root == null) {
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            System.out.print(cur.val + " ");
        }
        return ;
    }

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
     * @param root
     */
    public List<List<Character>> levelOrder2(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();//这个值代表当前层 有几个节点
            List<Character> list = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }


}
