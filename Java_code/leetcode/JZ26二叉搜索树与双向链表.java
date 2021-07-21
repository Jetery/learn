public class Solution {
    
    public static TreeNode pre = null;
    public void ConvertChild(TreeNode node) {
        if (node == null) {
            return;
        }
        ConvertChild(node.left);
        
        //开始更改指向
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        
        ConvertChild(node.right);
    }
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode ret = pRootOfTree;
        ConvertChild(pRootOfTree);
        while (ret.left != null) {
            ret = ret.left;
        }
        return ret;
    }
}
