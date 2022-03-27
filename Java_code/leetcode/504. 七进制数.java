/*
给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。


示例 1:

输入: num = 100
输出: "202"
示例 2:

输入: num = -7
输出: "-10"

*/

class Solution {
    public String convertToBase7(int num) {
    	if (num == 0) return "0";
    	boolean flag = false;
    	if (num < 0) flag = true;
    	num = Math.abs(num);
    	StringBuilder sb = new StringBuilder();
    	while (num != 0) {
    		sb.append(num % 7);
    		num /= 7;
    	}
    	if (flag) sb.append("-");
    	return String.valueOf(sb.reverse());
    }
}