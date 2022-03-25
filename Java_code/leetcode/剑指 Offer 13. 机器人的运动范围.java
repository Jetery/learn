/*

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。

一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。

例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。

请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*/



class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return dfs(visit,0, 0, m, n, k);
    }

    private int dfs(boolean[][] visit, int i, int j, int m, int n, int k) {
        if (i >= m || j >= n || visit[i][j] || sum(i, j) > k)
            return 0;
        visit[i][j] = true;
        return 1 + dfs(visit, i + 1, j, m, n, k) + dfs(visit, i, j + 1, m, n, k);
    }

    private int sum(int i, int j) {
        return i / 10 + i % 10 + j / 10 + j % 10;
    }
}