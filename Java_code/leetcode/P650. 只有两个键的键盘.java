/*

最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：

    Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
    Paste（粘贴）：粘贴 上一次 复制的字符。

给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。

 

示例 1：

输入：3
输出：3
解释：
最初, 只有一个字符 'A'。
第 1 步, 使用 Copy All 操作。
第 2 步, 使用 Paste 操作来获得 'AA'。
第 3 步, 使用 Paste 操作来获得 'AAA'。

示例 2：

输入：n = 1
输出：0


*/

//  数学分析
class Solution {
	public int minSteps(int n){
		if (n == 1) return 0;
		// 是质数就直接返回
		if (isPrime(n)){
			return n;
		}
		// 分解因数
		for (int i = n / 2; i >= 2; i--){
			if (n % i == 0){
				// 找到最大因数，直接递归
				return minSteps(i) + minSteps(n / i);
			}
		}
		return 0;
	}
	private boolean isPrime(int n) {
		for (int i = 2;i <= Math.sqrt(n); i++){
			if (n % i == 0){
				return false;
			}
		}
		return true;
	}
}



//数学：试除法
class Solution {
	public int minSteps(int n){
		int ans = 0;
		for (int i = 2; i * i <= n; i++){
			while (n % i == 0){
				ans += i;
				n /= i;
			}
		}
		if (n != 1) ans += n;
		return ans;
	}
}
