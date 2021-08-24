class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int count = 1;
        while(cur.next != null){
            count++;
            cur = cur.next;
        }
        int k = count / 2;
        while(k > 0){
            head = head.next;
            k--;
        }
        return head;
    }
}