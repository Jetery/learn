/*

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。

例如输入字符串"I am a student. "，则输出"student. a am I"。



示例 1：

输入: "the sky is blue"
输出:"blue is sky the"
示例 2：

输入: " hello world! "
输出:"world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。



示例 3：

输入: "a good  example"
输出:"example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/

注意：此题对比原题有改动



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        //  去除 开头 和 结尾 的空格
        int begin = 0, end = s.length() - 1;
        while (begin <= end && chars[begin] == ' ') begin++;
        while (end >= begin && chars[end] == ' ') end--;
        //  整体翻转 单词之间只要一个空格
        for (int i = end; i >= begin;) {
            char c = chars[i];
            if (c == ' ') {
                builder.append(c);
                while (i >= 0 && chars[i] == c) i--;
            } else {
                builder.append(c);
                i--;
            }
        }
        //  逐个单词翻转
        chars = builder.toString().toCharArray();
        builder.delete(0, builder.length());
        int i = 0, j = 0;
        while (i < chars.length && j < chars.length) {
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            i = j + 1;
            j = i;
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}