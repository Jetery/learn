/*

我们定义，在以下情况时，单词的大写用法是正确的：

    全部字母都是大写，比如 "USA" 
    单词中所有字母都不是大写，比如 "leetcode" 
    如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 

给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 

 

示例 1：

	输入：word = "USA"
	输出：true

示例 2：

	输入：word = "FlaG"
	输出：false

 

提示：

    1 <= word.length <= 100
    word 由小写和大写英文字母组成



*/

//大写字符A到Z的ASCII代码分别是065到090
//小写字符a到z的ASCII代码分别是097到122

//  纯模拟
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1){
            return true;
        }
        char[] words = word.toCharArray();
        byte flag = 0;
        if (words[0] >= 65 && words[0] <= 90){
            flag = 1;
        }
        if (words[1] >= 97){
            flag = -1;
        }
        for (int i = 2; i < words.length; i++){
            //全部是大写
            while (flag == 1 && i < words.length && words[i] <= 90){
                i++;
            }
            if (flag == 1 && i < words.length && words[i] >= 97){
                return false;
            }
            //首字母大写
            while (flag == -1 && i < words.length && words[i] >= 97){
                i++;
            }
            if (flag == -1 && i < words.length && words[i] <= 90){
                return false;
            }
        }
        return flag == 1 || flag == -1;
    }
}
