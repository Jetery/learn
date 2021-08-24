#define _CRT_SECURE_NO_WARNINGS 1


/*
//从键盘任意输入三个整数表示的分数，编程判断其中的最高分。
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



//有一个字符，判断它是否为大写字母，如果是，将它转换成小写字母；反之则转换为大写字母。
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
