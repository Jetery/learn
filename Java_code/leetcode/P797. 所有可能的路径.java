/**
 * 
给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。

译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。

 

示例 1：

输入：graph = [[1,2],[3],[3],[]]
输出：[[0,1,3],[0,2,3]]
解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3

 */



class Solution {
    int[][] g;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = graph.length;
        cur.add(0);
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == n - 1) {
            ans.add(new ArrayList<>(cur));
            return ;
        }
        for (int num : g[i]) {
            cur.add(num);
            dfs(num);
            cur.remove(cur.size() - 1);
        }
    }
}