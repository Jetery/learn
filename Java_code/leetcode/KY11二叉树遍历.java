import java.util.*;


class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode (char val) {
        this.val = val;
    }
}

public class Main {
    
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    
    public static int i = 0;
    public static TreeNode creatByString(String str) {
        if (str == null) {
            return null;
        }
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = creatByString(str);
            root.right = creatByString(str);
        } else {
            i++;
        }
        return root;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        TreeNode root = creatByString(str);
        inOrder(root);
    }
}
