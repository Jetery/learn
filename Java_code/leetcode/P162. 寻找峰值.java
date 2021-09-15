/*

峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

 

示例 1：

输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。

示例 2：

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5 
解释：你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。

 

提示：

    1 <= nums.length <= 1000
    -231 <= nums[i] <= 231 - 1
    对于所有有效的 i 都有 nums[i] != nums[i + 1]



*/


class Solution {
    public int findPeakElement(int[] nums) {
        if  (nums.length == 1) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < nums.length - 1; i++){
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                list.add(i);
            }
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]){
            list.add(nums.length -1);
        }
        int ret = list.get(list.size() -1);
        return ret;
    }
}


/*

二分

题目让我们实现一个 O(log⁡n)O(\log{n})O(logn) 算法，这是对使用「二分」的强烈暗示。

和往常的题目一样，我们应当从是否具有「二段性」来考虑是否可以进行「二分」。

不难发现，如果 在确保有解的情况下，我们可以根据当前的分割点 midmidmid 与左右元素的大小关系来指导 lll 或者 rrr 的移动。

假设当前分割点 midmidmid 满足关系 num[mid]>nums[mid+1]num[mid] > nums[mid + 1]num[mid]>nums[mid+1] 的话，
一个很简单的想法是 num[mid]num[mid]num[mid] 可能为峰值，而 nums[mid+1]nums[mid + 1]nums[mid+1] 必然不为峰值，
于是让 r=midr = midr=mid，从左半部分继续找峰值。

估计不少同学靠这个思路 AC 了，只能说做法对了，分析没对。

上述做法正确的前提有两个：

    对于任意数组而言，一定存在峰值（一定有解）；
    二分不会错过峰值。

我们分别证明一下。

证明 111 ：对于任意数组而言，一定存在峰值（一定有解）

根据题意，我们有「数据长度至少为 111」、「越过数组两边看做负无穷」和「相邻元素不相等」的起始条件。

我们可以根据数组长度是否为 111 进行分情况讨论：

    数组长度为 111，由于边界看做负无穷，此时峰值为该唯一元素的下标；

    数组长度大于 111，从最左边的元素 nums[0]nums[0]nums[0] 开始出发考虑：
        如果 nums[0]>nums[1]nums[0] > nums[1]nums[0]>nums[1]，那么最左边元素 nums[0]nums[0]nums[0] 就是峰值（结合左边界为负无穷）；
        如果 nums[0]<nums[1]nums[0] < nums[1]nums[0]<nums[1]，由于已经存在明确的 nums[0]nums[0]nums[0] 和 nums[1]nums[1]nums[1] 大小关系，
        我们将 nums[0]nums[0]nums[0] 看做边界， nums[1]nums[1]nums[1] 看做新的最左侧元素，继续往右进行分析：
            如果在到达数组最右侧前，出现 nums[i]>nums[i+1]nums[i] > nums[i + 1]nums[i]>nums[i+1]，
            说明存在峰值位置 iii（当我们考虑到 nums[i]nums[i]nums[i]，必然满足 nums[i]nums[i]nums[i] 大于前一元素的前提条件，
            当然前一元素可能是原始左边界）；
            到达数组最右侧，还没出现 nums[i]>nums[i+1]nums[i] > nums[i + 1]nums[i]>nums[i+1]，说明数组严格递增。
            此时结合右边界可以看做负无穷，可判定 nums[n−1]nums[n - 1]nums[n−1] 为峰值。

综上，我们证明了无论何种情况，数组必然存在峰值。

证明 222 ：二分不会错过峰值

其实基于「证明 111」，我们很容易就可以推理出「证明 222」的正确性。

整理一下由「证明 111」得出的推理：如果当前位置大于其左边界或者右边界，那么在当前位置的右边或左边必然存在峰值。

换句话说，对于一个满足 nums[x]>nums[x−1]nums[x] > nums[x - 1]nums[x]>nums[x−1] 的位置，xxx 的右边一定存在峰值；或对于一个满足 nums[x]>nums[x+1]nums[x] > nums[x + 1]nums[x]>nums[x+1] 的位置，xxx 的左边一定存在峰值。

因此这里的「二段性」其实是指：在以 midmidmid 为分割点的数组上，根据 nums[mid]nums[mid]nums[mid] 与 nums[mid±1]nums[mid \pm 1]nums[mid±1] 的大小关系，可以确定其中一段满足「必然有解」，另外一段不满足「必然有解」（可能有解，可能无解）。

    如果不理解为什么「证明 222」的正确性可以由「证明 111」推导而出的话，可以重点看看「证明 111」的第 222 点的证明。

至此，我们证明了始终选择大于边界一端进行二分，可以确保选择的区间一定存在峰值，并随着二分过程不断逼近峰值位置。

另外，为了照顾还在纠结使用什么“模板”的同学，特意写了两个版本。但其实只要搞清楚我们「二分」什么内容，根本不会存在说用哪种方式才能写过的情况。


*/

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}