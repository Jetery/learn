<<<<<<< HEAD
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.12
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0 || head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(n >= 0){      //因为要删除，fast要比slow快 n + 1 个
            fast = fast.next;
            if(fast == null){
                if(slow.next == null){
                    return null;    //只有一个节点的情况
                }
                if(n > 0){      //n在==0之前到底，说明要删的就是倒数第n个
                    head = head.next;
                    return head;
                } else {
                    break;
                }
            }
            n--;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
=======
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.12
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0 || head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(n >= 0){      //因为要删除，fast要比slow快 n + 1 个
            fast = fast.next;
            if(fast == null){
                if(slow.next == null){
                    return null;    //只有一个节点的情况
                }
                if(n > 0){      //n在==0之前到底，说明要删的就是倒数第n个
                    head = head.next;
                    return head;
                } else {
                    break;
                }
            }
            n--;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
>>>>>>> 1871cb1360925d0595677df79f7630ea32a0682e
