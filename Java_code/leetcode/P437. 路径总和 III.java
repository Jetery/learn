/*

给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 

示例 1：

输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。

示例 2：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3



*/


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
    int ans = 0, target = 0;
    public int pathSum(TreeNode root, int targetSum) {
    	target = targetSum;
    	dfs1(root);
    	return ans;

    }

    private void dfs1(TreeNode root) {
    	if (root == null) return;
    	dfs2(root, root.val);
    	dfs1(root.left);
    	dfs1(root.right);
    }


    //  双递归， 用前序遍历的节点位根节点再次遍历
    //  二次递归时求和，必须多一个参数
    private void dfs2(TreeNode root, int value) {
    	if (value == target) ans++;
    	if (root.left != null) dfs2(root.left, root.left.val + value);
    	if (root.right != null) dfs2(root.right, root.right.val + value);
    }

}



// 待补充::树的前缀和方法