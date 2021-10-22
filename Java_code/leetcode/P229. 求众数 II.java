/*

给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

 

 

示例 1：

输入：[3,2,3]
输出：[3]

示例 2：

输入：nums = [1]
输出：[1]

示例 3：

输入：[1,1,1,3,3,2,2,2]
输出：[1,2]

 

提示：

    1 <= nums.length <= 5 * 104
    -109 <= nums[i] <= 109

 

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

*/


//  暴力
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n , 0) + 1);
        }
        int n = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()){
            int times = map.get(key);
            if (times > n){
                list.add(key);
            }
        }
        return list;
    }
}


//  最优 :: 摩尔投票