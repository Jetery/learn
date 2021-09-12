/*
给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。

示例 1:

输入: 5
输出: 5
解释: 
下面是带有相应二进制表示的非负整数<= 5：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。

*/

class Solution {
	public int findIntegers(int n) {
		int[] dp = new int[32];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < 32; i++){
			dp[i] = dp[i-1] + dp[i - 2];
		}
		String str = getBinary(n);
		int ans = 0;
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) == '0') 
				continue;
			ans += dp[str.length() - i - 1];
			if (i != 0 && str.charAt(i - 1) == '1'){
			// 因为== 0就跳过，那么当进行了此if判断时：前一位是1，必然已有连续1，后面数据全部非法，不用考虑了
				return ans;
			}
		}
		return ans + 1;
	}

	private String getBinary(int n){
		StringBuilder sb = new StringBuilder();
		while (n > 0){
			sb.insert(0, n & 1);
			n >>= 1;
		}
		return sb.toString();
	}
}