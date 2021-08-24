#include "game.h"

void InitBoard(char Board[ROW][COL], int row, int col)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			Board[i][j] = ' ';
		}
	}
}


////low版本
//void DisplayBoard(char Board[ROW][COL], int row, int col)
//{
//	int i = 0;
//	for (i = 0; i < row; i++)
//	{
//		printf(" %c | %c | %c \n", Board[i][0], Board[i][1], Board[i][2]);
//		if (i<row-1)
//			printf("---|---|---\n");
//	}
//}

void DisplayBoard(char Board[ROW][COL], int row, int col)
{
	int i = 0;
	for (i = 0; i < row; i++)
	{
		int j = 0;
		//打印棋
		for (j = 0; j < col; j++)
		{
			printf(" %c ", Board[i][j]);
			if (j < col - 1)
			{
				printf("|");
			}
		}
		printf("\n");
		//打印隔板
		if (i < row - 1)
		{
			for (j = 0; j < col; j++)
			{
				printf("---");
				if (j < col - 1)
				{
					printf("|");
				}
			}
			printf("\n");
		}
	}
}


void PlayerMove(char Board[ROW][COL], int row, int col)
{
	int x = 0;
	int y = 0;	
	printf("玩家走:>\n");
	while (1)
	{
		printf("输入坐标:");
		scanf("%d %d", &x, &y);
		if (x >= 1 && x <= row && y >= 1 && y <= col)
		{
			if (Board[x - 1][y - 1] == ' ')
			{
				Board[x - 1][y - 1] = '*';
				break;
			}
			else
			{
				printf("该坐标已被占用！\n");
			}
		}
		else
		{
			printf("请输入合法坐标！\n");
		}
	}
}

void ComputerMove(char Board[ROW][COL], int row, int col)
{
	printf("电脑走:>\n");
	while (1)
	{
		int x = rand() % row;
		int y = rand() % col;
		if (Board[x][y] == ' ')
		{
			Board[x][y] = '#';
			break;
		}
	}
}

//判断棋盘是否填满
//返回1为满
static int IsFull(char Board[ROW][COL], int row, int col)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (Board[i][j] == ' ')
				return 0;
		}
	}
	return 1;
}

char CheckWin(char Board[ROW][COL], int row, int col)
{
	//横向三子
	int i = 0;
	for (i = 0; i < row; i++)
	{
		if (Board[i][0] == Board[i][1] && Board[i][1] == Board[i][2] && Board[i][0] != ' ')
		{
			return Board[i][0];
		}
	}
	//竖向三子
	int j = 0;
	for (j = 0; j < col; j++)
	{
		if (Board[0][j] == Board[1][j] && Board[1][j] == Board[2][j] && Board[0][j] != ' ')
		{
			return Board[0][j];
		}
	}
	//斜向三子
	if (Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2] && Board[0][0] != ' ')
	{
		return Board[0][0];
	}
	if (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0] && Board[0][2] != ' ')
	{
		return Board[0][2];
	}
	//平局
	int a = IsFull(Board, row, col);
	if (1 == a)
	{
		return 'Q';
	}
	//继续游戏
	return 'C';
}