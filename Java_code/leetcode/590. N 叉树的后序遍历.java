/*


给定一个 n 叉树的根节点root，返回 其节点值的 后序遍历 。

n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。



示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：[5,6,3,2,4,1]



示例 2：
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]


出处:
https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

//  use 递归
class Solution {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    public void dfs(Node root) {
        if (root == null) return;
        for (Node elem : root.children) {
            dfs(elem);
        }
        ans.add(root.val);
    }
}

//  use 迭代
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return ans;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                List<Node> child = node.children;
                for (int i = child.size() - 1; i >= 0; i--)
                    stack.push(child.get(i));
            } else {
                ans.add(stack.pop().val);
            }
        }
        return ans;
    }
}