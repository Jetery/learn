/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.16
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = list1;
        ListNode aft = list1;
        while(a > 1 || b > 0){
            pre = a <= 1 ? pre : pre.next;
            aft = b <= 0 ? aft : aft.next;
            a--;
            b--;
        }

        ListNode cur = list2;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = aft.next;
        aft.next = null;
        pre.next = list2;
        return list1;
    }
}