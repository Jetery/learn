/*

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值


出处:
https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (A.val == B.val && help(A.left, B.left) && help(A.right, B.right)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean help(TreeNode a, TreeNode b) {
        //  b 已经遍历完
        if (b == null) return true;
        //  a 已经遍历完
        if (a == null) return false;
        if (a.val != b.val) return false;
        return help(a.left, b.left) && help(a.right, b.right);
    }
    
}