/*
给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。

每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。

这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。

返回一个由上述 k 部分组成的数组。
 

示例 1：

输入：head = [1,2,3], k = 5
输出：[[1],[2],[3],[],[]]
解释：
第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。

示例 2：

输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
输出：[[1,2,3,4],[5,6,7],[8,9,10]]
解释：
输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。


*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
    	int n = 0;
    	ListNode cur = head;
        // 得到链表长度
    	while (cur != null){
    		cur = cur.next;
    		n++;
    	}
    	// 基本长度
    	int base = n / k;
    	// 由于左边要大于右边，待补充个数
    	int left = n % k;
    	// 由于每一次向数组中注入一个，base为0，
        // 说明left分给有限的每一个元素只有 1
        // 那么可以忽略 left
    	if (base == 0) {
    		left = -1;
    	}
    	ListNode[] ans = new ListNode[k];
    	for (int i = 0; i < k; i++){
    		// 为 null 则补齐
            // 最开始处理null
            // 为后续考虑复杂度降低
    		if (head == null){
    			ans[i] = null;
    			break;
    		}
    		// 已经消耗掉base一个长度
    		ans[i] = head;

    		for (int j = 0; j < base - 1; j++){
    			// 除去已消耗的
                // 向后移动 base-1 个
    			head = head.next;
    		}
    		// 处理左边更多情况
    		if (left-- > 0){
    			head = head.next;
    		}
    		// 将尾部置空
    		ListNode next = head.next;
    		head.next = null;
    		head = next;
    	}
    	return ans;
    }
}