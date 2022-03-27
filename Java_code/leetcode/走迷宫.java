/*

表示一个迷宫，其中的1表示墙壁，0表示可以走的路，

只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。

入口点为[0,0], 既第一空格是可以走的路。

Input
	一个N × M的二维数组，表示一个迷宫。

	数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道

Output
	左上角到右下角的最短路径，格式如样例所示

Sample Input
	0 1 0 0 0
	0 1 0 1 0
	0 0 0 0 0
	0 1 1 1 0
	0 0 0 1 0

Sample Output
	(0, 0)
	(1, 0)
	(2, 0)
	(2, 1)
	(2, 2)
	(2, 3)
	(2, 4)
	(3, 4)
	(4, 4)

输入描述:
	输入两个整数，分别表示二位数组的行数，列数。

	再输入相应的数组，其中的1表示墙壁，0表示可以走的路。

	数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
	
输出描述:
	左上角到右下角的最短路径，格式如样例所示。

示例1
	输入
		5 5
		0 1 0 0 0
		0 1 0 1 0
		0 0 0 0 0
		0 1 1 1 0
		0 0 0 1 0
	输出
		(0,0)
		(1,0)
		(2,0)
		(2,1)
		(2,2)
		(2,3)
		(2,4)
		(3,4)
		(4,4)

*/


import java.util.*;

public class Main{

    public static int leastStep;
    public static LinkedList<int[]> shortPath;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            // 获得迷宫
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            boolean[][] mark = new boolean[m][n];
            LinkedList<int[]> path = new LinkedList<>();
            shortPath = new LinkedList<>();
            shortPath.add(new int[]{6, 6});
            path.add(new int[]{0, 0});
            leastStep = Integer.MAX_VALUE;
            mark[0][0] = true;
            dfs(arr, mark, 0, 0, path, m, n);
            for (int[] ints : shortPath) {
                System.out.println("(" + ints[0] + "," + ints[1] + ")");
            }
        }
    }

    private static void dfs(int[][] arr, boolean[][] mark, int i, int j,
                            LinkedList<int[]> path, int row, int column) {
        if (i == row - 1 && j == column - 1) {
            if (path.size() < leastStep) {
                shortPath = new LinkedList<>(path);
                leastStep = path.size();
            }
            return;
        }
        int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            int x = i + move[k][0];
            int y = j + move[k][1];
            if (x < 0 || x >= row || y < 0 || y >= column) {
                continue;
            }
            if (mark[x][y]) {
                continue;
            }
            if (arr[x][y] == 1) {
                continue;
            }
            mark[x][y] = true;
            path.add(new int[]{x, y});
            dfs(arr, mark, x, y, path, row, column);
            path.removeLast();
            mark[x][y] = false;
        }
    }
}
