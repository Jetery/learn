import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    //迭代版
    void preOrderTraversalNor(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {

            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val + " ");
                cur = cur.left;

            }

            cur = stack.pop().right;
        }
        System.out.println();
    }

    // 中序遍历
    void inOrderTraversal(TreeNode root){
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    //迭代版
    void inOrderTraversalNor(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
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

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(TreeNode root) {
        if (root == null) return;
        if (root.right == null && root.left == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    //求第 k 层结点个数
    int getKLevelSize(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k - 1) + getKLevelSize(root.right,k - 1);
    }

    // 获取二叉树的高度
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }


    TreeNode find(TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left,val);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right,val);
        return ret;
    }


    // 层序遍历
    void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            System.out.println(top.val + " ");
            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
        }
        System.out.println();
    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top != null) {
                queue.offer(top.left);
                queue.offer(top.right);
            } else {
                int size = queue.size();
                while (size != 0) {
                    if (queue.poll() != null) {
                        return false;
                    }
                    size--;
                }
            }
        }
        return true;
    }
}
