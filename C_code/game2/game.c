#include "game.h"

void InitBoard(char board[ROWS][COLS], int rows, int cols, char c)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < rows; i++)
	{
		for (j = 0; j < cols; j++)
		{
			board[i][j] = c;
		}
	}
}


int GetMine(char mine[ROWS][COLS], int x, int y)
{
	return mine[x - 1][y] +
		mine[x - 1][y - 1] +
		mine[x][y - 1] +
		mine[x + 1][y - 1] +
		mine[x+1][y] +
		mine[x + 1][y + 1] +
		mine[x][y + 1] +
		mine[x - 1][y + 1] - 8 * '0';
}

//循环法
//int GetMine(char mine[ROWS][COLS], int x, int y)
//{
//	int i = 0;
//	int j = 0;
//	int sum = '0';
//	for (i = x - 1; i <= x + 1; i++)
//	{
//		for (j = y - 1; j <= y + 1; j++)
//		{
//			sum += mine[i][j];
//		}
//	}
//	return sum - 10 * '0';
//}


void FindCount(char mine[ROWS][COLS], 
	char show[ROWS][COLS], 
	int row, int col, 
	int count)
{
	int x = 0;
	int y = 0;
	int win = 0;
	while (win<row*col-count)
	{
		printf("请输入坐标:>");
		scanf("%d %d", &x, &y);
		//确保合法
		if (x >= 1 && x <= row&&y >= 1 && y <= col)
		{
			if (mine[x][y] == '0')//不是雷则统计
			{
				int num = GetMine(mine, x, y);
				show[x][y] = num + '0';
				DisplayBoard(show, row, col);
				win++;
			}
			else
			{
				printf("碰到了炸弹，你输了！\n");
				DisplayBoard(show, row, col);
				break;
			}
		}
		else
		{
			printf("坐标非法，请重新输入！\n");
		}
	}
	if (win == col*row - count)
	{
		printf("恭喜你，胜利了！\n");
	}
}


void SetMine(char board[ROWS][COLS], int row, int col, int count)
{
	while (count)
	{
		int x = rand() % 9 + 1;
		int y = rand() % 9 + 1;
		//确保布置的雷不重复
		if (board[x][y] == '0')
		{
			board[x][y] = '1';
			count--;
		}
	}
}


void DisplayBoard(char board[ROWS][COLS], int row, int col)
{
	int i = 0;
	int j = 0;
	printf("————————扫雷游戏——————————\n");
	for (i = 0; i <= col; i++)
	{
		printf("%d ", i);
	}
	printf("\n");
	for (i = 1; i <= row; i++)
	{
		printf("%d ", i);
		for (j = 1; j <= col; j++)
		{
			printf("%c ", board[i][j]);
		}
		printf("\n");
	}
	printf("————————扫雷游戏——————————\n");
}
