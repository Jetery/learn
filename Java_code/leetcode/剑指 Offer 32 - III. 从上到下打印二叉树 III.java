/*

请实现一个函数按照之字形顺序打印二叉树，

即第一行按照从左到右的顺序打印，

第二层按照从右到左的顺序打印，

第三行再按照从左到右的顺序打印，其他行以此类推。


*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean flag = true;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode top = queue.poll();
                if (flag) {
                    list.add(top.val);
                } else {
                    stack.push(top.val);
                }
                size--;
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            if (flag) {
                ans.add(list);
            } else {
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                ans.add(list);
            }
            flag = !flag;
        }
        return ans;
    }
}