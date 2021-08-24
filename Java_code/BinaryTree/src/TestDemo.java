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
        treeNode.preOrderTraversalNor(root);

        treeNode.inOrderTraversal(root);
        System.out.println();
        treeNode.inOrderTraversalNor(root);

        treeNode.postOrderTraversal(root);
        System.out.println();
        treeNode.postOrderTraversalNor(root);

        treeNode.getSize1(root);
        System.out.println(BinaryTree.num);

        System.out.println(treeNode.getSize2(root));

        treeNode.getLeafSize1(root);

        System.out.println(BinaryTree.leafSize);
        System.out.println(treeNode.getLeafSize2(root));

        System.out.println(treeNode.getKLevelSize(root,4));

        System.out.println(treeNode.find(root, 'G'));
    }
}
