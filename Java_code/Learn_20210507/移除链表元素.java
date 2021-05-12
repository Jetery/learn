class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
            pre = cur;
            cur =cur.next;
            }
        }
        if (head.val == val) head = head.next;
        return head;
    }
}
