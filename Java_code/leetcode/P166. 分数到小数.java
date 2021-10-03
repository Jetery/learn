/*

给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。

如果小数部分为循环小数，则将循环的部分括在括号内。

如果存在多个答案，只需返回 任意一个 。

对于所有给定的输入，保证 答案字符串的长度小于 104 。

 

示例 1：

输入：numerator = 1, denominator = 2
输出："0.5"

示例 2：

输入：numerator = 2, denominator = 1
输出："2"

示例 3：

输入：numerator = 2, denominator = 3
输出："0.(6)"

示例 4：

输入：numerator = 4, denominator = 333
输出："0.(012)"

示例 5：

输入：numerator = 1, denominator = 5
输出："0.2"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/


class Solution {
	/**
	 
	模拟竖式除法

	a = a * 10;
    sb.append(a / b);
    a %= b;

	 */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        //  防止数据溢出
        long a = numerator, b = denominator;
        StringBuilder sb = new StringBuilder();
        //  考虑负数
        if (a * b < 0) sb.append('-');
        //  因为负数已经被排除  只进行正数运算
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        //  可以整除的情况  直接返回
        if (a % b == 0) return String.valueOf(sb);
        sb.append('.');
        a %= b;
        HashMap<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            map.put(a, sb.length());
            a = a * 10;
            sb.append(a / b);
            a %= b;
            //  开始出现循环
            if (map.containsKey(a)) {
                int u = map.get(a);
                sb.insert(u, '(');
                sb.append(')');
                break;
            }
        }
        return sb.toString();
    }
}