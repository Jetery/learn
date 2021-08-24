#include "game.h"

void menu()
{
	printf("*****************************************\n");
	printf("************    1.play    ***************\n");
	printf("************    0.exit    ***************\n");
	printf("*****************************************\n");
}

void game()
{
	char mine[ROWS][COLS];
	char show[ROWS][COLS];
	//初始化棋盘
	InitBoard(mine, ROWS, COLS,'0');
	InitBoard(show, ROWS, COLS,'*');
	//布置雷
	SetMine(mine, ROW, COL, EASY_NUM);
	//展示棋盘
	DisplayBoard(mine, ROW, COL);
	DisplayBoard(show, ROW, COL);
	//排雷
	FindCount(mine, show, ROW, COL,EASY_NUM);
}

int main()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do
	{
		menu();
		printf("请选择:>");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("游戏结束\n");
			break;
		default:
			printf("选择错误，请重新选择。\n");
			break;
		}
	} while (input);
	return 0;
}