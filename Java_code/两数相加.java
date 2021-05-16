/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.16
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int then = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while(l1 != null || l2 != null || then != 0){

            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + then;

            int nextVal = sum % 10;
            then = sum / 10;

            ListNode temp = new ListNode(nextVal);
            cur.next = temp;
            cur = cur.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return head.next;
    }
}
