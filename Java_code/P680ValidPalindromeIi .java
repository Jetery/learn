//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 354 👎 0


package leetcode.editor.cn;
//Java：验证回文字符串 Ⅱ
public class P680ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new P680ValidPalindromeIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                if(judge(s,left + 1,right) || judge(s, left, right - 1)){
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public boolean judge(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
