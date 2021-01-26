#define _CRT_SECURE_NO_WARNINGS 1
/*
//实现一个函数，判断一个数是不是素数。
//利用上面实现的函数打印100到200之间的素数。
#include <stdio.h>
#include <math.h>
int judge(int x)
{
	int j = 2;
	for (; j <= sqrt(x);j++)
	{
		if (x % j == 0)
		{
			return 0;
		}
	}
	return 1;
}

int main()
{
	int i = 0;
	for (i = 101; i <= 200; i+=2)
	{
		int b;
		b = judge(i);
		if (1==b)
		printf("%d ", i);
	}
	return 0;
}
*/

/*
//实现函数判断year是不是润年
#include <stdio.h>
int judge(int x)
{
	if (((x % 4 == 0) && (x % 100 != 0)) || (x % 400 == 0))
	{
		return 1;
	}
}

int main()
{
	int y = 0;
	scanf("%d", &y);
	int b = 0;
	b = judge(y);
	if (b = 1)
		printf("yes");
	return 0;
}
*/


/*
//实现一个函数来交换两个整数的内容
#include <stdio.h>
void exchange(int* x, int* y)
{
	int temp = 0;
	temp = *x;
	*x = *y;
	*y = temp;
}
int main()
{
	int a = 10;
	int b = 20;
	exchange(&a, &b);
	printf("a = %d b = %d", a, b);
	return 0;
}
*/

/*
//实现一个函数，打印乘法口诀表，口诀表的行数和列数自己指定
//如：输入9，输出9 * 9口诀表，输出12，输出12 * 12的乘法口诀表
#include <stdio.h>
void print(int i)
{
	int j = 0;
	int a = 0;
	for (a = 1; a <= i; a++)
	{
		for (j = 1; j <= a; j++)
		{
			printf("%d * %d =%-2d ", j, a, a*j);
		}
		printf("\n");
	}
}

int main()
{
	int i = 0;
	scanf("%d", &i);
	print(i);
	return 0;
}
*/


/*
//昨日 OJ 改进版
//从键盘输入若干组成绩，每组7个分数（百分制），去掉一个最高分和一个最低分，输出每组的平均成绩
#include <stdio.h>
int main()
{
	int i = 0;
	int a[7] = { 0 };
	int max = 0;
	int min = 100;
	int score = 0;
	for (i = 1; i <= 7; i++)
	{
		scanf("%d", &a[i]);
		score += a[i];
	}
	for (i = 1; i <= 7; i++)
	{
		if (max < a[i])
		{
			max = a[i];
		}
		if (min > a[i])
		{
			min = a[i];
		}
	}
	score = score - max - min;
	float ave = 0.0;
	ave = score / 5.0;
	printf("%.2f", ave);
	return 0;
}
*/


//昨日 OJ 改进版
//多组输入年份和月份，计算这一年这个月有多少天
#include <stdio.h>
int main()
{
	int year = 0;
	int month = 0;
	int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	while (scanf("%d %d", &year, &month) != EOF)
	{
		int day = 0;
		day = days[month - 1];
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
		{
			if (2 == month)
			{
				day++;
			}
		}
		printf("%d\n", day);
	}
	return 0;
}
