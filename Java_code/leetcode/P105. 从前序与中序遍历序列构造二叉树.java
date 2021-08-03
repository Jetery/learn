class Solution {

    public TreeNode buildTreeChild(int[] preorder, int preBegin, int preEnd,
                                   int[] inorder, int inBegin, int inEnd){
        if (preBegin > preEnd || inBegin > inEnd){
            return null;
        }
        //前序第一个就是根节点
        TreeNode root = new TreeNode(preorder[preBegin]);
        int inIndex = inBegin;
        //找到中序对应下标
        while (preorder[preBegin] != inorder[inIndex]) {
            inIndex++;
        }
        //左右区间的范围表示
        root.left = buildTreeChild(preorder, preBegin + 1, preBegin + inIndex - inBegin, inorder, inBegin, inIndex - 1);
        root.right = buildTreeChild(preorder, preBegin + inIndex - inBegin + 1, preEnd, inorder, inIndex + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        int preLen = preorder.length;
        int inLen = inorder.length;
        return buildTreeChild(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }
}