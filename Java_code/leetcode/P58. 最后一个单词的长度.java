/*

给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

 

示例 1：

输入：s = "Hello World"
输出：5

示例 2：

输入：s = "   fly me   to   the moon  "
输出：4

示例 3：

输入：s = "luffy is still joyboy"
输出：6

*/


// 库函数
class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        return str[str.length - 1].length();
    }
}



// 双指针
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') j--;
        return i - j;
    }
}