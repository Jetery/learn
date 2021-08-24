#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROW 9
#define COL 9
#define ROWS ROW+2
#define COLS COL+2

//雷的数量
#define EASY_NUM 80

//初始化棋盘
void InitBoard(char board[ROWS][COLS], int rows, int cols, char c);

//打印棋盘
void DisplayBoard(char board[ROWS][COLS], int row, int col);

//布置雷
//mine  存储雷信息
//row - 行数
//col - 列数
//count - 雷的数量
void SetMine(char board[ROWS][COLS], int row, int col,int count);

//排雷
void FindCount(char mine[ROWS][COLS],
	char show[ROWS][COLS], 
	int row, int col, 
	int count);