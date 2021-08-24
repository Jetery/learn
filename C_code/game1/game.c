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


////low�汾
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
		//��ӡ��
		for (j = 0; j < col; j++)
		{
			printf(" %c ", Board[i][j]);
			if (j < col - 1)
			{
				printf("|");
			}
		}
		printf("\n");
		//��ӡ����
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
	printf("�����:>\n");
	while (1)
	{
		printf("��������:");
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
				printf("�������ѱ�ռ�ã�\n");
			}
		}
		else
		{
			printf("������Ϸ����꣡\n");
		}
	}
}

void ComputerMove(char Board[ROW][COL], int row, int col)
{
	printf("������:>\n");
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

//�ж������Ƿ�����
//����1Ϊ��
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
	//��������
	int i = 0;
	for (i = 0; i < row; i++)
	{
		if (Board[i][0] == Board[i][1] && Board[i][1] == Board[i][2] && Board[i][0] != ' ')
		{
			return Board[i][0];
		}
	}
	//��������
	int j = 0;
	for (j = 0; j < col; j++)
	{
		if (Board[0][j] == Board[1][j] && Board[1][j] == Board[2][j] && Board[0][j] != ' ')
		{
			return Board[0][j];
		}
	}
	//б������
	if (Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2] && Board[0][0] != ' ')
	{
		return Board[0][0];
	}
	if (Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0] && Board[0][2] != ' ')
	{
		return Board[0][2];
	}
	//ƽ��
	int a = IsFull(Board, row, col);
	if (1 == a)
	{
		return 'Q';
	}
	//������Ϸ
	return 'C';
}