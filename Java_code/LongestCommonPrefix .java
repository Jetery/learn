//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1624 👎 0


package leetcode.editor.cn;
//Java：最长公共前缀
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0){
            return "";
        }
        String s = strs[0];
        if (len == 1){
            return s;
        }
        for (int i = 0; i < len; i++) {
            if (!strs[i].startsWith(s)){
                s = s.substring(0,s.length() - 1);
                i--;
            }
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
