#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

int Compare(int x,int y)
{
	if (x > y)
	{
		return x;
	}
	else
	{
		return y;
	}
}

int main()
{
	int a = 0,b = 0;
	scanf("%d %d", &a, &b);
	int c = Compare(a, b);
	printf("%d", c);
	return 0;
}