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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return DFS(root, targetSum);
    }
    
    private boolean DFS(TreeNode root, int value) {
        if (root.left == null && root.right == null) {
            return value - root.val == 0;
        }
        if (root.left != null && DFS(root.left, value - root.val)) {
            return true;
        }
        return root.right != null && DFS(root.right, value - root.val);
    }
}