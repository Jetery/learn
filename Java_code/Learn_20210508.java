//1.递归
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode del = pHead.next;
        if (pHead.val == del.val){
            while(del != null && pHead.val == del.val){
                del = del.next;
            }
            return deleteDuplication(del);
        }else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}


//2.遍历
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode del = head;
        while(del != null && del.next != null){
            if(del.val == del.next.val){
                while(del.next != null && del.val == del.next.val){
                    del = del.next;
                }
                cur.next = del.next;
                //del = del.next;
            } else {
                cur = cur.next;
                //del = del.next;
            }
            del = del.next;
        }
        return newHead.next;
    }
}
