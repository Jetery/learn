class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top != null) {
                queue.offer(top.left);
                queue.offer(top.right);
            } else {
                int size = queue.size();
                while (size != 0) {
                    if (queue.poll() != null) {
                        return false;
                    }
                    size--;
                }
            }
        }
        return true;
    }
}