/*

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 
示例 1：

输入：head = [1,3,2]
输出：[2,3,1]


*/

//  先反转 再复制


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
            size++;
        }
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = newHead.val;
            newHead = newHead.next;
        }
        return ans;
    }
}