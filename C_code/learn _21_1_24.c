#define _CRT_SECURE_NO_WARNINGS 1


/*
//�Ӽ���������������������ʾ�ķ���������ж����е���߷֡�
#include <stdio.h>
int main()
{
	int a = 0;
	int b = 0;
	int c = 0;
	while (scanf("%d %d %d", &a, &b, &c) != EOF)
	{
		int z = a>b ? a : b;
		z = z>c ? z : c;
		printf("%d\n", z);
	}
	return 0;
}
*/



//��һ���ַ����ж����Ƿ�Ϊ��д��ĸ������ǣ�����ת����Сд��ĸ����֮��ת��Ϊ��д��ĸ��
#include <stdio.h>
int main()
{
	char letter;
	while (scanf("%c", &letter) != EOF)
	{
		getchar();
		if (letter >= 'a'&&letter <= 'z')
		{
			printf("%c\n", letter - 32);
		}
		else if (letter <= 'a'&&letter <= 'z')
		{
			printf("%c\n", letter + 32);
		}
	}
	return 0;
}
