/*

给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：

字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
每个元音'a'后面都只能跟着'e'
每个元音'e'后面只能跟着'a'或者是'i'
每个元音'i'后面不能 再跟着另一个'i'
每个元音'o'后面只能跟着'i'或者是'u'
每个元音'u'后面只能跟着'a'
由于答案可能会很大，所以请你返回 模10^9 + 7之后的结果。



示例 1：

输入：n = 1
输出：5
解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
示例 2：

输入：n = 2
输出：10
解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
示例 3：

输入：n = 5
输出：68


提示：

1 <= n <= 2 * 10^4

*/

class Solution {
    public int countVowelPermutation(int n) {
        int MOD = (int)(Math.pow(10, 9) + 7);
        long[][] f = new long[n][5];
        Arrays.fill(f[0], 1);
        for (int i = 0; i < n - 1; i++){
            // 每个元音 'a' 后面都只能跟着 'e'
            f[i + 1][1] += f[i][0];
            // 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
            f[i + 1][0] += f[i][1];
            f[i + 1][2] += f[i][1];
            // 每个元音 'i' 后面 不能 再跟着另一个 'i'
            f[i + 1][0] += f[i][2];
            f[i + 1][1] += f[i][2];
            f[i + 1][3] += f[i][2];
            f[i + 1][4] += f[i][2];
            // 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
            f[i + 1][2] += f[i][3];
            f[i + 1][4] += f[i][3];
            // 每个元音 'u' 后面只能跟着 'a'
            f[i + 1][0] += f[i][4];
            for (int j = 0; j < 5; j++) f[i + 1][j] %= MOD;
        }
        long ans = 0;
        for (int i = 0; i < 5; i++){
            ans += f[n - 1][i];
        }
        return (int)(ans % MOD);
    }
}