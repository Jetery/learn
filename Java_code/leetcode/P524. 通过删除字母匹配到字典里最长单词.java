/*
给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。

 

示例 1：

输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
输出："apple"

示例 2：

输入：s = "abpcplea", dictionary = ["a","b","c"]
输出："a"


*/




class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dictionary.size(); i++){
            String str = dictionary.get(i);
            int x = 0, y = 0;
            for ( ; x < s.length(); x++){
                if (y < str.length() && s.charAt(x) == str.charAt(y)){
                    y++;
                }
            }
            if (y == str.length()){
                list.add(str);
            }
        }
        String ans = "";
        for (int i = 0; i < list.size(); i++){
            String str = list.get(i);
            if (str.length() > ans.length()){
                ans = str;
            } else if (str.length() == ans.length()){
                int l = 0, r = 0;
                for (int j = 0; j < ans.length(); j++){
                    l += str.charAt(j) - 'a';
                    r += ans.charAt(j) - 'a';
                    if (l < r){
                        ans = str;
                    } else if (l > r){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}


/*

排序 + 双指针 + 贪心

根据题意，我们需要找到 dictionary 中为 s 的子序列，且「长度最长（优先级 111）」及「字典序最小（优先级 222）」的字符串。

数据范围全是 100010001000。

我们可以先对 dictionary 根据题意进行自定义排序：

    长度不同的字符串，按照字符串长度排倒序；
    长度相同的，则按照字典序排升序。

然后我们只需要对 dictionary 进行顺序查找，找到的第一个符合条件的字符串即是答案。

具体的，我们可以使用「贪心」思想的「双指针」实现来进行检查：

    使用两个指针 i 和 j 分别代表检查到 s 和 dictionary[x] 中的哪位字符；
    当 s[i] != dictionary[x][j]，我们使 i 指针右移，直到找到 s 中第一位与 dictionary[x][j] 对得上的位置，然后当 i 和 j 同时右移，匹配下一个字符；
    重复步骤 222，直到整个 dictionary[x] 被匹配完。

    证明：对于某个字符 dictionary[x][j] 而言，选择 s 中 当前 所能选择的下标最小的位置进行匹配，对于后续所能进行选择方案，会严格覆盖不是选择下标最小的位置，因此结果不会变差。

作者：AC_OIer
链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/solution/gong-shui-san-xie-xiang-jie-pai-xu-shuan-qi20/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

class Solution {
    public String findLongestWord(String s, List<String> list) {
        Collections.sort(list, (a,b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : list) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }
}
