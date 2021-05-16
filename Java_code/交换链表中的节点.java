/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.16
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode last = head;
        while(fast != null && k > 1){
            fast = fast.next;
            last = last.next;
            k--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        int temp = slow.val;
        slow.val = last.val;
        last.val = temp;
        return head;
    }
}