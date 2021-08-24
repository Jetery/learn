class Solution {
    public ListNode middleIndex(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode Switch(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode middle = middleIndex(head);
        ListNode end = Switch(middle);
        while(head != end){
            if(head.val == end.val){
                head = head.next;
                end = end.next;
                if(head.next == null){
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
