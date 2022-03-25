class Solution {

    public void tree2strChild(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null) {
            if (root.right == null) {
                return;
            } else {
                sb.append("()");
            }
        } else {
            sb.append('(');
            tree2strChild(root.left, sb);
            sb.append(')');
        }

        if (root.right == null) {
            return;
        } else {
            sb.append('(');
            tree2strChild(root.right, sb);
            sb.append(')');
        }
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        tree2strChild(root, sb);
        return sb.toString();
    }
}



class Solution {

    StringBuilder stringBuilder;

    public String tree2str(TreeNode root) {
        if (root == null) return null;
        stringBuilder = new StringBuilder();
        preOrder(root);
        return String.valueOf(stringBuilder);
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        } else if (root.left == null) {
            stringBuilder.append("()");
            stringBuilder.append("(");
            preOrder(root.right);
            stringBuilder.append(")");
        } else if (root.right == null) {
            stringBuilder.append("(");
            preOrder(root.left);
            stringBuilder.append(")");
        } else {
            stringBuilder.append("(");
            preOrder(root.left);
            stringBuilder.append(")");
            stringBuilder.append("(");
            preOrder(root.right);
            stringBuilder.append(")");
        }
        return;
    }
}