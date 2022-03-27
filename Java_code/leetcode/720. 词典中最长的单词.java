/*


给出一个字符串数组words 组成的一本英语词典。返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。

若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。

示例 1：

输入：words = ["w","wo","wor","worl", "world"]
输出："world"
解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。



示例 2：

输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出："apple"
解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




*/

//  先对数组进行排序(字母序)  可保证遍历时由短到长, 由低到高

class Solution {
    public String longestWord(String[] words) {
    	// 先处理
        Arrays.sort(words);
        TreeSet<String> set = new TreeSet<>();
        String ans = "";
        for (String s : words) {
        	//  由于每个单词要从第一个字母开始, 故 s.length() == 1 也在判定条件中
        	//  substring 的取值是左闭右开, 但是 s.length() 得到的值比下标大1  故需要减一
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                ans = s.length() > ans.length() ? s : ans;
                set.add(s);
            }
        }
        return ans;
    }
}