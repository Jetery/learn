/*


统计一个数字在排序数组中出现的次数。



示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2




示例2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*/

//  二分
class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int elem = nums[mid];
            if (elem < target) {
                i = mid + 1;
            } else if (elem > target) {
                j = mid - 1;
            } else {
                i = mid;
                j = mid;
                while (i >= 0 && target == nums[i]) {
                    i--;
                }
                while (j < nums.length && target == nums[j]) {
                    j++;
                }
                break;
            }
        }
        return j - i > 0 ? j - i - 1 : 0;
    }
}