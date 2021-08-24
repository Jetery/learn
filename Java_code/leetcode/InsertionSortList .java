
package leetcode.editor.cn;
//Java：对链表进行插入排序
public class P147InsertionSortList{
    public static void main(String[] args) {
        Solution solution = new P147InsertionSortList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode newHead = new ListNode(0,head);
        while (cur != null){
            if(pre.val <= cur.val){
                pre = pre.next;
                cur = cur.next;
            } else {
                pre.next = cur.next;
                ListNode temp = newHead;
                while (temp.next.val <= cur.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
                temp.next = cur;
                cur = pre.next;
            }
        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
