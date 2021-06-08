/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.08
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree treeNode = new BinaryTree();
        TreeNode root = treeNode.creatTree();
        treeNode.preOrderTraversal(root);
        System.out.println();
        treeNode.inOrderTraversal(root);
        System.out.println();
        treeNode.postOrderTraversal(root);
        System.out.println();
        treeNode.getSize1(root);
        System.out.println(BinaryTree.num);
        System.out.println(treeNode.getSize2(root));
    }
}
