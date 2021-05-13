public class Partition {
    public ListNode partition(ListNode head, int x) {
        // write code here
        if(head == null) return null;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        while(head != null){
            if(head.val < x){
                if(bs == null){
                    bs = head;
                    be = head;
                }else{
                    be.next = head;
                    be = be.next;
                }
            }else{
                if(as == null){
                    as = head;
                    ae = head;
                }else{
                    ae.next = head;
                    ae = ae.next;
                }
            }
            head = head.next;
        }
        if (ae != null) ae.next = null;
        if (bs == null) return as;
        if(be == null){
            be = as;
            return bs;
        }
        be.next = as;
        return bs;
    }
}
