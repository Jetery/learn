/*


多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

 

示例 1：

输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
输出：[1,2,3,7,8,11,12,9,10,4,5,6]
解释：

输入的多级列表如下图所示：



示例 2：

输入：head = [1,2,null,3]
输出：[1,3,2]
解释：

输入的多级列表如下图所示：

  1---2---NULL
  |
  3---NULL

示例 3：

输入：head = []
输出：[]

 

如何表示测试用例中的多级链表？

以 示例 1 为例：

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

序列化其中的每一级之后：

[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]

为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。

[1,2,3,4,5,6,null]
[null,null,7,8,9,10,null]
[null,11,12,null]

合并所有序列化结果，并去除末尾的 null 。

[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

*/


/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/


// 递归方法
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur.child == null && cur.next != null) cur = cur.next;
        Node temp = cur.next;
        Node child = cur.child;
        // 此处要将孩子节点置空，否则会是无效的双向链表
        cur.child = null;
        // if chlid == null means cur.next == null
        // all is null so return head
        if (child == null) return head;
        // 扁平化处理
        Node newHead = flatten(child);
        // 插入需要扁平的数据
        // attention :: 后驱、前驱都要处理
        cur.next = newHead;
        newHead.prev = cur;
        // 得到扁平的尾巴
        while (newHead.next != null) newHead = newHead.next;
        newHead.next = temp; 
        // 拼接temp
        if (temp != null) temp.prev = newHead;
        return head;
    }
}


// 迭代方法

class Solution {
    public Node flatten(Node head) {
    	
    }
}