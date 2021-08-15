
class Solution {

    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int m = pairs.length;
        for (int i = 0; i < n; i++) {
            int[] p = preferences[i];
            Map<Integer, Integer> cur = new HashMap<>();
            for (int j = 0; j < n - 1; j++) cur.put(p[j], n - j);
            map.put(i, cur);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int x = pairs[i][0], y = pairs[i][1];
            boolean xok = false, yok = false;
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                int u = pairs[j][0], v = pairs[j][1];
                if (!xok && check(x, y, u, v)) xok = true;
                if (!yok && check(y, x, u, v)) yok = true;
                if (xok && yok) break;
            }
            if (xok) ans++;
            if (yok) ans++;
        }
        return ans;
    }
    boolean check(int x, int y, int u, int v) {
        Map<Integer, Integer> xmap = map.get(x), ymap = map.get(y);
        Map<Integer, Integer> umap = map.get(u), vmap = map.get(v);
        if (xmap.get(u) > xmap.get(y) && umap.get(x) > umap.get(v)) return true;
        if (xmap.get(v) > xmap.get(y) && vmap.get(x) > vmap.get(u)) return true;
        return false;
    }
}