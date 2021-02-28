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

//ѭ����
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
		printf("����������:>");
		scanf("%d %d", &x, &y);
		//ȷ���Ϸ�
		if (x >= 1 && x <= row&&y >= 1 && y <= col)
		{
			if (mine[x][y] == '0')//��������ͳ��
			{
				int num = GetMine(mine, x, y);
				show[x][y] = num + '0';
				DisplayBoard(show, row, col);
				win++;
			}
			else
			{
				printf("������ը���������ˣ�\n");
				DisplayBoard(show, row, col);
				break;
			}
		}
		else
		{
			printf("����Ƿ������������룡\n");
		}
	}
	if (win == col*row - count)
	{
		printf("��ϲ�㣬ʤ���ˣ�\n");
	}
}


void SetMine(char board[ROWS][COLS], int row, int col, int count)
{
	while (count)
	{
		int x = rand() % 9 + 1;
		int y = rand() % 9 + 1;
		//ȷ�����õ��ײ��ظ�
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
	printf("����������������ɨ����Ϸ��������������������\n");
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
	printf("����������������ɨ����Ϸ��������������������\n");
}
