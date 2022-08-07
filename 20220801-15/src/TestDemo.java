/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -01
 * Time: 23:02
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root =  binaryTree.createNode1();
        System.out.println("sasasa");
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();

        System.out.println(binaryTree.getSize1(root));
        System.out.println(binaryTree.getSize2(root));

        System.out.println("========叶子结点的个数========");
        binaryTree.getLeafSize1(root);
        System.out.println(binaryTree.leafSize);
        System.out.println(binaryTree.getLeafSize2(root));

        System.out.println("========第k层节点的个数========");
        System.out.println(binaryTree.getKLevelSize(root,5));
        System.out.println(binaryTree.getKLevelSize(root,4));
        System.out.println(binaryTree.getKLevelSize(root,3));
        System.out.println(binaryTree.getKLevelSize(root,2));
        System.out.println(binaryTree.getKLevelSize(root,1));
        System.out.println(binaryTree.getKLevelSize(root,0));

        System.out.println("========整棵树的高度========");
        System.out.println(binaryTree.getHeight(root));

        try {
            System.out.println(binaryTree.find(root, 't').val);
            System.out.println(binaryTree.find(root, 'G').val);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        }

        binaryTree.isCompleteTree(root);
        System.out.println("========判断这棵树是否为完全二叉树========");
        System.out.println(binaryTree.isCompleteTree(root));

        System.out.println("========输出这棵树的层序遍历========");
        binaryTree.levelOrder1(root);
    }
}
