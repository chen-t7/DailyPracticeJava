/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -01
 * Time: 22:55
 */
class BTNode {
    public char val;
    public BTNode left;//左孩子的引用
    public BTNode right;//右孩子的引用
    public BTNode(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    public BTNode root;//二叉树的跟根节点

    public BTNode creatNode() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }


}
