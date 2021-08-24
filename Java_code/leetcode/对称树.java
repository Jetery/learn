/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        return root == null || MyisSymmetric(root.left, root.right);
    }
    
    private boolean MyisSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return MyisSymmetric(left.left, right.right) && MyisSymmetric(left.right, right.left);
    }
}


//use stack
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            TreeNode tree1 = stack.pop();
            TreeNode tree2 = stack.pop();
            if (tree1 == null && tree2 == null) {
                continue;
            }
            if (tree1 == null || tree2 == null || tree1.val != tree2.val) {
                return false;
            }
            stack.push(tree1.left);
            stack.push(tree2.right);
            stack.push(tree2.left);
            stack.push(tree1.right);
        }
        return true;
    }
}