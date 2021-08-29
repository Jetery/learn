/*
给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

子数组 定义为原数组中的一个连续子序列。

请你返回 arr 中 所有奇数长度子数组的和 。

 

示例 1：

输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58


*/



//time: O(N^2)    space: O(n)
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        //前缀和数组
        int[] add = new int[arr.length  + 1];
        for (int i = 1; i < add.length; i++) add[i] = add[i - 1] + arr[i - 1];

        int ans = 0;
        for (int i = 0; i < add.length; i++) {
            for (int j = i + 1; j < add.length; j += 2) {
                int sum = add[j] - add[i];
                ans += sum;
            }
        }
        return ans;
    }
}



//事实上，我们可以统计任意只 arr[i]arr[i]arr[i] 在奇数子数组的出现次数。
//尚未理解,有待增加