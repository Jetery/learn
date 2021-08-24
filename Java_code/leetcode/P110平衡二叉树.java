class Solution {

    public int hight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = hight(root.left);
        int rightHeight = hight(root.right);
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) < 2) {
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        } else {
            return -1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return hight(root) >= 0;
    }
}