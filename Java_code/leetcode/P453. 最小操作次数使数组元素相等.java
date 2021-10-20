/*

给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。

返回让数组所有元素相等的最小操作次数。
 

示例 1：

输入：nums = [1,2,3]
输出：3
解释：
只需要3次操作（注意每次操作会增加两个元素的值）：
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

示例 2：

输入：nums = [1,1,1]
输出：0

 

提示：

    n == nums.length
    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
    答案保证符合 32-bit 整数

*/

// 使 n - 1 个元素加一，和让一个元素减一是同样的效果， 找到最小元素min，求min和别的元素的差值的和即可
class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int n : nums){
            min = Math.min(n, min);
        }
        int ans = 0;
        for (int n : nums){
            ans += n - min;
        }
        return ans;
    }
}