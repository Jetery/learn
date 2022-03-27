/*
给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

请返回 nums 的动态和。

 

示例 1：

输入：nums = [1,2,3,4]
输出：[1,3,6,10]
解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 

*/


//今天这简单到不行好吧，想做错都难
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums[0];
        for (int i = 1;i < nums.length; i++) {
            n += nums[i];
            nums[i] = n;
        }
        return nums;
    }
}