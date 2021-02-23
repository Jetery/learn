
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
		printf("���Ӯ��\n");
	}
	else if (ret == '#')
	{
		printf("����Ӯ��\n");
	}
	else if (ret == 'Q')
	{
		printf("ƽ��\n");
	}
	DisplayBoard(Board, ROW, COL);
}


int main()
{
	//�������������
	srand((unsigned int)time(NULL));
	int input = 0;
	do
	{
		menu();
		printf("��ѡ��:>\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�˳���Ϸ\n");
			break;
		default:
			printf("ѡ���������ѡ��\n");
		}
	} while (input);
	return 0;
}