/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.08
 */
public class BinaryTree {

    public TreeNode creatTree(){
        TreeNode a =  new TreeNode('A');
        TreeNode b =  new TreeNode('B');
        TreeNode c =  new TreeNode('C');
        TreeNode d =  new TreeNode('D');
        TreeNode e =  new TreeNode('E');
        TreeNode f =  new TreeNode('F');
        TreeNode g =  new TreeNode('G');
        TreeNode h =  new TreeNode('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        return a;
    }

    //前序遍历
    void preOrderTraversal(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(TreeNode root){
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(TreeNode root){
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    // 遍历思路-求结点个数
    static int num = 0;
    void getSize1(TreeNode root){
        if(root == null) return;
        num++;
        getSize1(root.left);
        getSize1(root.right);
    }

    //子问题思路-求结点个数
    int getSize2(TreeNode root){
        if(root == null) return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;
    }
}
