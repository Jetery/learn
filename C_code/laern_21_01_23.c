//猜数字游戏
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//游戏开始界面
void menu()
{
	printf("******* 猜数字游戏 ******\n");
	printf("****** 范围是1~~99 ******\n");
	printf("*******  1. play  *******\n");
	printf("*******  0. exit  *******\n");
	printf("*************************\n");
}

//游戏模块
void game()
{
	//引入随机数
	srand((unsigned int)time(NULL));
	int ret = rand() % 100 + 1;

	//猜数字
	int guess = 0;
	while (1)
	{
		printf("猜一猜:>");
		scanf("%d", &guess);
		if (guess < ret)
		{
			printf("猜小了\n");
		}
		else if (guess>ret)
		{
			printf("猜大了\n");
		}
		else
		{
			printf("猜对了\n");
			break;
		}
	}
}

int main()
{
	int input = 0;
	do
	{
		menu();
		printf("请选择(1/0)");
		scanf("%d", &input);
		switch(input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("退出游戏\n");
			break;
		default:
			printf("选择错误\n");
			break;
		}
	} while (input);
	return 0;
}