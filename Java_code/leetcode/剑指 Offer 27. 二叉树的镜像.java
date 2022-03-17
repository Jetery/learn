/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//  递归
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode ans = new TreeNode(root.val);
        ans.left = mirrorTree(root.right);
        ans.right = mirrorTree(root.left);
        return ans;
    }
}


//  use stack
//  可以发现 此方法和 层序遍历 非常相似
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                TreeNode temp = top.left;
                top.left = top.right;
                top.right = temp;
                stack.push(top.left);
                stack.push(top.right);
            }
        }
        return root;
    }
}


//  use queue
//  由于栈先进后出, 队列先进先出, 所以只有一个细节不一样
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top != null) {
                TreeNode temp = top.left;
                top.left = top.right;
                top.right = temp;
                //  the only difference with stack
                queue.offer(top.right);
                queue.offer(top.left);
            }
        }
        return root;
    }
}