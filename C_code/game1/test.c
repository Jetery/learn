
#include "game.h"
void menu()
{
	printf("***********************\n");
	printf("******** 1.play *******\n");
	printf("******** 0.exit *******\n");
	printf("***********************\n");
}


void game()
{
	char ret = 0;
	char Board[ROW][COL];
	InitBoard(Board, ROW, COL);
	DisplayBoard(Board, ROW, COL);
	while (1)
	{
		PlayerMove(Board, ROW, COL);
		DisplayBoard(Board, ROW, COL);
		ret = CheckWin(Board, ROW, COL);
		if (ret != 'C')
		{
			break;
		}
		ComputerMove(Board, ROW, COL);
		DisplayBoard(Board, ROW, COL);
		ret = CheckWin(Board, ROW, COL);
		if (ret != 'C')
		{
			break;
		}
	}
	if (ret == '*')
	{
		printf("玩家赢了\n");
	}
	else if (ret == '#')
	{
		printf("电脑赢了\n");
	}
	else if (ret == 'Q')
	{
		printf("平局\n");
	}
	DisplayBoard(Board, ROW, COL);
}


int main()
{
	//电脑下棋随机数
	srand((unsigned int)time(NULL));
	int input = 0;
	do
	{
		menu();
		printf("请选择:>\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("退出游戏\n");
			break;
		default:
			printf("选择错误，重新选择\n");
		}
	} while (input);
	return 0;
}