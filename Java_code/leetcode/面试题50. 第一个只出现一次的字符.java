/*

在字符串 s 中找出第一个只出现一次的字符。
如果没有，返回一个单空格。 s 只包含小写字母。

示例 1:
输入：s = "abaccdeff"
输出：'b'


示例 2:
输入：s = "" 
输出：' '

*/


class Solution {
    public char firstUniqChar(String s) {
        int[] pool = new int[26];
        char ret = ' ';
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            pool[elem - 'a'] = pool[elem - 'a'] + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            if (pool[elem - 'a'] == 1) {
                return elem;
            }
        }
        return ret;
    }
}