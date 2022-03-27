/*
给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。

 

示例 1：

输入：a = 1, b = 2
输出：3

示例 2：

输入：a = 2, b = 3
输出：5

*/


//  迭代
class Solution {
    public int getSum(int a, int b) {
    	//  a ^ b 获得无进位加法
    	//  (a & b) << 1 获得进位
        while (b != 0){
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}


//  数学模拟
class Solution {
    public int getSum(int a, int b) {
    	int ans = 0;
    	int carry = 0;
    	for (int i = 0; i < 32; i++){
    		int x = (a >> i) & 1;
    		int y = (b >> i) & 1;
    		//  两者都是1，说明当前位有进位
    		if (x == 1 && y == 1){
    			ans |= (carry << i);
    			carry = 1;
    		//  有一个是1，取决于前一位进位
    		} else if (x == 1 || y == 1){
    			ans |= (carry ^ 1) << i;
    		//  没有 1，进位置为 0 
    		} else {
    			ans |= (carry << i);
    			carry = 0;
    		}
    	}
    	return ans;
    }
}