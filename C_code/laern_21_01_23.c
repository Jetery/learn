//��������Ϸ
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//��Ϸ��ʼ����
void menu()
{
	printf("******* ��������Ϸ ******\n");
	printf("****** ��Χ��1~~99 ******\n");
	printf("*******  1. play  *******\n");
	printf("*******  0. exit  *******\n");
	printf("*************************\n");
}

//��Ϸģ��
void game()
{
	//���������
	srand((unsigned int)time(NULL));
	int ret = rand() % 100 + 1;

	//������
	int guess = 0;
	while (1)
	{
		printf("��һ��:>");
		scanf("%d", &guess);
		if (guess < ret)
		{
			printf("��С��\n");
		}
		else if (guess>ret)
		{
			printf("�´���\n");
		}
		else
		{
			printf("�¶���\n");
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
		printf("��ѡ��(1/0)");
		scanf("%d", &input);
		switch(input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�˳���Ϸ\n");
			break;
		default:
			printf("ѡ�����\n");
			break;
		}
	} while (input);
	return 0;
}