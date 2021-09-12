/*
给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

    任何左括号 ( 必须有相应的右括号 )。
    任何右括号 ) 必须有相应的左括号 ( 。
    左括号 ( 必须在对应的右括号之前 )。
    * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
    一个空字符串也被视为有效字符串。

示例 1:

输入: "()"
输出: True

示例 2:

输入: "(*)"
输出: True

示例 3:

输入: "(*))"
输出: True

*/

class Solution {
    public boolean checkValidString(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<>();
        Stack<Character> help = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' ||  c == '*'){
                stack.push(c);
            } else {
                if (stack.isEmpty() && help.isEmpty()) return false;
                while (!stack.isEmpty() || !help.isEmpty()){
                    if (!stack.isEmpty()){
                        if (stack.peek() == '('){
                            stack.pop();
                            while (!help.isEmpty()){
                                stack.push(help.pop());
                            }
                        } else {
                            help.push(stack.pop());
                            continue;
                        }
                    } else {
                        help.pop();
                        while (!help.isEmpty()){
                            stack.push(help.pop());
                        }
                    }
                    break;
                }
            }
        }
        while (!stack.isEmpty()){
            if (stack.peek() == '('){
                if (!help.isEmpty()){
                    stack.pop();
                    help.pop();
                } else {
                    return false;
                }
            } else {
                help.push(stack.pop());
            }
        }
        return true;
    }
}





/*
令左括号的得分为 111；右括号的得分为 −1-1−1。那么对于合法的方案而言，必定满足最终得分为 000。

同时由于本题存在 *，因此我们需要记录得分的区间区间是多少，而不仅是一个具体的得分。

具体的，使用两个变量 l 和 r 分别表示「最低得分」和「最高得分」。

根据当前处理到的字符进行分情况讨论：

    当前字符为 ( : l 和 r 同时加一；
    当前字符为 ) : l 和 r 同时减一；
    当前字符为 * : 如果 * 代指成 ( 的话，l 和 r 都进行加一；如果 * 代指成 ) 的话，l 和 r 都进行减一；如果 * 不变的话，l 和 r 均不发生变化。因此总的 l 的变化为减一，总的 r 的变化为加一。

需要注意的是，在匹配过程中如果 l 为负数，需要重置为 000，因为如果当前序列本身为不合法括号序列的话，增加 ( 必然还是不合法。同时，当出现 l > r 说明上界为负数，即右括号过多，必然为非合法方案，返回 falsefalsefalse。

作者：AC_OIer
链接：https://leetcode-cn.com/problems/valid-parenthesis-string/solution/gong-shui-san-xie-yi-ti-shuang-jie-dong-801rq/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/

class Solution {
    public boolean checkValidString(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++; r++;
            } else if (c == ')') {
                l--; r--;
            } else {
                l--; r++;
            }
            l = Math.max(l, 0);
            if (l > r) return false;
        }
        return l == 0;
    }
}