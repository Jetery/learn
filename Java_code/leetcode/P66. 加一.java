/*

给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

 

示例 1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

示例 2：

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。

示例 3：

输入：digits = [0]
输出：[1]

*/

class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length + 1];
        int cnt = digits.length - 1;
        int carry = digits[cnt] + 1;
        while (cnt >= 0){  
            ans[cnt + 1] = carry % 10;
            cnt--;
            if (cnt >= 0) {
                carry = carry / 10 + digits[cnt];
            }
        }
        ans[0] = carry / 10;
        if (ans[0] == 0){
            int[] arr = new int[digits.length];
            for (int i = 0; i < digits.length; i++){
                arr[i] = ans[i+1];
            }
            return arr;
        }
        return ans;
    }
}