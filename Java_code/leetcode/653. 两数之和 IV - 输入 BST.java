/*

给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。



示例 1：

输入: root = [5,3,6,2,4,null,7], k = 9
输出: true



示例 2：

输入: root = [5,3,6,2,4,null,7], k = 28
输出: false


提示:

二叉树的节点个数的范围是[1, 104].
-104 <= Node.val <= 104
root 为二叉搜索树
-105 <= k <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

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

    List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int l = 0, r = list.size() - 1;
        //for (int i : list) System.out.print(i + " ");
        //   双指针查找
        while (l < r) {
            if (list.get(l) + list.get(r) < k) {
                l++;
            } else if (list.get(l) + list.get(r) > k) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return;
    }
}




