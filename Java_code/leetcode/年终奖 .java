/*

小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，

游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，

他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，

一路上的格子里的礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物。

给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值 ,

左上角为[0,0] , 请返回能获得的最大价值，保证每个礼物价值大于100小于1000。

*/

import java.util.*;

public class Bonus {
    public int getMost(int[][] board) {
        // write code here
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
            	//  起点位置不做处理
                if (i == 0 && j == 0){
                    continue;
                //  第一行的元素只能获得来自左边的礼物
                } else if (i == 0){
                    board[i][j] += board[i][j - 1];
                //  每一行的第一个元素的只能获得来自上方的礼物
                } else if (j == 0){
                    board[i][j] += board[i - 1][j];
                //  除了以上情况, 均可以去获得来自 左 或者 上 的礼物
                //  固取最大值
                } else {
                    board[i][j] += Math.max(board[i - 1][j], board[i][j - 1]);
                }
            }
        }
        return board[board.length - 1][board[0].length - 1];
    }
}
