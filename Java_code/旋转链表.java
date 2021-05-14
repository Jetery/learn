/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.14
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        //ListNode move = head;
        int n = 1;
        while(cur.next != null){
            cur = cur.next;
            n++;
        }
        cur.next = head;
        k %= n;
        while(n - k > 1){
            head = head.next;
            n--;
        }
        cur = head.next;
        head.next = null;
        return cur;
    }
}