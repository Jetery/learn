/*


给定一个整数 n ，返回 n! 结果中尾随零的数量。

提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1



示例 1：

输入：n = 3
输出：0
解释：3! = 6 ，不含尾随 0



示例 2：

输入：n = 5
输出：1
解释：5! = 120 ，有一个尾随 0



示例 3：

输入：n = 0
输出：0


提示：

0 <= n <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*/

class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            int temp = n;
            while (temp >= 5 && temp % 5 == 0) {
                temp /= 5;
                ans++;
            }
            n--;
        }
        return ans;
    }
}

//  更快的方法


class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }
}