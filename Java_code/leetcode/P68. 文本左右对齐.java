/*

给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

    单词是指由非空格字符组成的字符序列。
    每个单词的长度大于 0，小于等于 maxWidth。
    输入单词数组 words 至少包含一个单词。

示例:

输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

示例 2:

输入:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。

示例 3:

输入:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int count = 0;
        int start = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            count += words[i].length();
            if (count > maxWidth) {
                ans.add(helper(start, i - 1, words, maxWidth));
                start = i;
                count = words[i].length();
            }
            // 每个单词结尾都有一个空格
            count++;
        }

        //  处理最后一行
        ans.add(helper(start, n - 1, words, maxWidth));
        return ans;
    }

    private String helper(int start, int end, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            one(start, words, maxWidth, sb);
        } else if (end == words.length - 1) {
            last(start, end, words, maxWidth, sb);
        } else {
            normal(start, end, words, maxWidth, sb);
        }
        return sb.toString();
    }

    // 处理最后一行
    private void last(int start, int end, String[] words, int maxWidth, StringBuilder sb){
        int count = 0;
        for (int i = start; i <= end; i++){
            count += words[i].length();
            //  结尾处理的细节
            if (i != end)count++;
        }
        int space = maxWidth - count;
        for (int i = start; i <= end; i++){
            sb.append(words[i]);
            //  结尾处理的细节
            if (i != end) sb.append(" ");
        }

        for (int i = 0; i < space; i++) {
            sb.append(" ");
        }
    }

    //  处理只有一个单词的情况
    private void one(int start, String[] words, int maxWidth, StringBuilder sb){
        int space = maxWidth - words[start].length();
        sb.append(words[start]);
        while(space-- > 0){
            sb.append(" ");
        }
    }

    //  处理一般情况
    private void normal(int start, int end, String[] words, int maxWidth, StringBuilder sb){
        int numOfGap = end - start;
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += words[i].length();
        }
        int space = (maxWidth - count) / numOfGap;
        int remain = (maxWidth - count) % numOfGap;
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            //  结尾处理的细节
            if (i != end){
                for (int j = 0; j < space; j++){
                    sb.append(" ");
                }
            }
            if (remain > 0){
                sb.append(" ");
                remain--;
            }
        }
    }
}


//精简版本， 来自 力扣作者  AC_OIer
// for 循环的 i++ 放到循环里面根据不同情况来执行下个阶段 i 的变化
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            // list 装载当前行的所有 word
            list.clear();
            list.add(words[i]);
            int cur = words[i++].length();
            while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                cur += 1 + words[i].length();
                list.add(words[i++]);
            }

            // 当前行为最后一行，特殊处理为左对齐
            if (i == n) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while (sb.length() < maxWidth) sb.append(" ");
                ans.add(sb.toString());
                break;
            }

            // 如果当前行只有一个 word，特殊处理为左对齐
            int cnt = list.size();
            if (cnt == 1) {
                String str = list.get(0);
                while (str.length() != maxWidth) str += " ";
                ans.add(str);
                continue;
            }

            /**
            * 其余为一般情况
            * wordWidth : 当前行单词总长度;
            * spaceWidth : 当前行空格总长度;
            * spaceItem : 往下取整后的单位空格长度
            */
            int wordWidth = cur - (cnt - 1);
            int spaceWidth = maxWidth - wordWidth;
            int spaceItemWidth = spaceWidth / (cnt - 1);
            String spaceItem = "";
            for (int k = 0; k < spaceItemWidth; k++) spaceItem += " ";
            StringBuilder sb = new StringBuilder();
            for (int k = 0, sum = 0; k < cnt; k++) {
                String item = list.get(k);
                sb.append(item);
                if (k == cnt - 1) break;
                sb.append(spaceItem);
                sum += spaceItemWidth;
                // 剩余的间隙数量（可填入空格的次数）
                int remain = cnt - k - 1 - 1;
                // 剩余间隙数量 * 最小单位空格长度 + 当前空格长度 < 单词总长度，则在当前间隙多补充一个空格
                if (remain * spaceItemWidth + sum < spaceWidth) {
                    sb.append(" ");
                    sum++;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
/*
作者：AC_OIer
链接：https://leetcode-cn.com/problems/text-justification/solution/gong-shui-san-xie-zi-fu-chuan-mo-ni-by-a-s3v7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/