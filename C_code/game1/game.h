#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROW 3
#define COL 3

//初始化棋盘
void InitBoard(char Board[ROW][COL],int row,int col);


//打印棋盘
void DisplayBoard(char Board[ROW][COL], int row, int col);


//玩家落子（*）
void PlayerMove(char Board[ROW][COL], int row, int col);

//电脑落子（#）
void ComputerMove(char Board[ROW][COL], int row, int col);

//判断输赢
char CheckWin(char Board[ROW][COL], int row, int col);
//返回'*'  玩家胜利
//返回'#'  电脑胜利
//返回'Q'  平局
//返回'C'  继续游戏

