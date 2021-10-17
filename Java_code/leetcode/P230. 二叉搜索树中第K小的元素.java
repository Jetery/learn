/*

给定一个二叉搜索树的根节点 root ，和一个整数 k ，

请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

 

示例 1：

输入：root = [3,1,4,null,2], k = 1
输出：1

示例 2：

输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3


*/



/**
 * 
 * 
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
 * 
 * 
 */

// space :: O(n)
class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return list.get(k - 1);
    }
    private void help(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        help(root.left);
        list.add(root.val);
        help(root.right);
    }
}


//  space :: O(1)
class Solution {
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return ans;
    }
    private void help(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        help(root.left, k);
        count++;
        if (count == k){
            ans = root.val;
        }
        help(root.right, k);
    }
}
