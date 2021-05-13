/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.13
 */
class Solution {
    public ListNode switchIndex(ListNode head,ListNode end){
        ListNode newHead = end;
        while(head != end){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && right > left - 1){
            fast = fast.next;
            right--;
        }

        if(left == 1){
            if(fast == slow.next){
                ListNode temp = fast;
                slow.next = fast.next;
                fast.next = slow;
                return temp;
            }
            if(fast.next == null && right == left){
                ListNode ret = switchIndex(slow,fast.next);
                return ret;
            }
            ListNode ret = switchIndex(slow,fast);
            return ret;
        }

        while(right > 1){
            fast = fast.next;
            slow = slow.next;
            right--;
        }
        ListNode ret = switchIndex(slow.next,fast.next);
        slow.next = ret;
        return head;
    }
}
