/*

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，

还有一个 random 指针指向链表中的任意节点或者 null。


示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]


示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]


示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]


*/

//  用 HashMap 得到一一对应关系, 然后二次遍历时, 完成复制, 实现映射关系
//  需要注意的是, map.get(head.next) 和 map.get(head).next 的区别

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node help = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (help != null) {
            Node temp = new Node(help.val, null, null);
            map.put(help, temp);
            help = help.next;
        }
        Node ans = map.get(head);
        help = ans;
        while (head != null) {
            ans.next = map.get(head.next);
            ans.random = map.get(head.random);
            ans = ans.next;
            head = head.next;
        }
        return help;
    }
} 