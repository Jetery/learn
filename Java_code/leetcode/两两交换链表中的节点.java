/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.14
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode temp = null;
        ListNode cur = head.next;
        ListNode ret = head.next;
        while(cur != null && cur.next != null){
            temp = cur.next;
            pre.next = temp.next;
            cur.next = pre;
            pre = temp;
            cur = temp.next;
        }
        if(cur == null){
            ListNode move = head;
            while(move.next != null){
                move = move.next;
            }
            move.next = pre;
            return ret;
        }
        cur.next = temp;
        if(temp == null){
            cur.next = pre;
            pre.next = null;
            return ret;
        }
        temp.next = null;
        return ret;
    }

}