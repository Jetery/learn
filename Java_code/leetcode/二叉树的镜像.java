    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return pRoot;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }