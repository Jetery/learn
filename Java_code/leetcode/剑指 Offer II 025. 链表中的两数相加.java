/*

给定两个 非空链表 l1和 l2来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

可以假设除了数字 0 之外，这两个数字都不会以零开头。


示例1：
输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]


示例2：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]


示例3：
输入：l1 = [0], l2 = [0]
输出：[0]


提示：

链表的长度范围为 [1, 100]
0 <= node.val <= 9
输入数据保证链表代表的数字无前导 0


进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lMSNwu
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


//  use stack
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        if (l2.val == 0) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        Stack<Integer> sum = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            carry += x + y;
            sum.push(carry % 10);
            carry /= 10;
        }
        ListNode ans = new ListNode();
        ListNode pos = new ListNode(sum.pop());
        ans.next = pos;
        while (!sum.isEmpty()) {
            pos.next = new ListNode(sum.pop());
            pos = pos.next;
        }
        return ans.next;
    }
}







