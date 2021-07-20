class Solution {

    private TreeNode res;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        res = dummy;
        inOrder(root);
        return dummy.right;
    }

    void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);

        res.right = root;
        root.left = null;
        res = root;

        inOrder(root.right);
        
    }


}