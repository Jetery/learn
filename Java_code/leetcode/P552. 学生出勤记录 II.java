class Solution {

    int mod = 1000000007;
    int[][][] mem;

    public int checkRecord(int n) {

        //三维
        //1. day    2. A    3. L
        mem = new int[n + 1][2][3];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    mem[i][j][k] = -1;
                }
            }
        }

        return dfs(n, 0, 0);
    }


    /**
    remains  待处理个数
    a        Absent
    l        Late
     */
    private int dfs(int remains, int a, int l) {
        if (a >= 2) return 0;
        if (l >= 3) return 0;
        if (remains == 0) return 1;
        if (mem[remains][a][l] != -1) return mem[remains][a][l];
        int ans = 0;
        // P
        ans = dfs(remains - 1, a, 0) % mod;
        // A
        ans = (ans + dfs(remains - 1, a + 1, 0)) % mod;
        // L
        ans = (ans + dfs(remains -1, a, l + 1)) % mod;

        //memoried
        mem[remains][a][l] = ans;
        
        return ans;
    }

}