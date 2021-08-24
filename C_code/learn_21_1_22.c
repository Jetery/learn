#define _CRT_SECURE_NO_WARNINGS 1
/*
//将三个数按从大到小输出
#include <stdio.h>
int main()
{
	int a, b, c;
	int z=0;
	scanf("%d%d%d", &a, &b, &c);
	if (c > a)
	{
	z = a;
	a = c;
	c = z;
	}
	if (b > a)
	{
	z = a;
	a = b;
	b = z;
	}
	if (c > b)
	{
	z = b;
	b = c;
	c = z;
	}
	printf("%d %d %d\n",a,b,c);
	return 0;
}
*/


/*
//打印1-100之间所有3的倍数的数字
#include <stdio.h>
int main()
{
	int a = 1;
	for (; a <= 100; a++)
	{
		if (a % 3 == 0)
		{
			printf("%d ", a);
		}
	}
	return 0;
}
*/

/*
//求两个数的最大公约数
#include <stdio.h>
int main()
{
	int a, b;
	scanf("%d%d", &a, &b);
	while (a%b != 0)
	{
		int z = a%b;
		a = b;
		b = z;
	}
	printf("%d", b);
	return 0;
}

*/
/*
//打印1000年到2000年之间的闰年
#include <stdio.h>
int main()
{
	int i;
	for (i = 1000; i <= 2000; i++)
	{
		if ((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0))
		{
			printf("%d ", i);
		}
	}
	return 0;
}
*/

/*
//打印100~200之间的素数
#include <stdio.h>
#include <math.h>
int main()
{
	int i,j;
	for (i = 100; i <= 200; i++)
	{
		int flag =1;
		for (j = 2; j <= sqrt(i); j++)
		{
			if (i%j == 0)
			{
				flag = 0;
				break;
			}
		}
		if (flag == 1)
		{
			printf("%d ", i);
		}
	}
	return 0;
}
*/

/*
//数9的个数
//1到 100 的所有整数中出现多少个数字9
#include <stdio.h>
int main()
{
	int a = 0;
	int b = 0;
	for (a = 1; a <= 100; a++)
	{
		if (a % 10 == 9)
			b++;
		if (a / 10 == 9)
			b++;
	}
	printf("%d ", b);
	return 0;
}
*/

/*
//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
#include <stdio.h>
int main()
{
	int i;
	double sum=0.0;
	int n = 1;
	for (i = 1; i <= 100; i++)
	{
		sum += n*(1.0 / i);
		n = -n;
	}
	printf("%lf", sum);
	return 0;
}
*/

////求10 个整数中最大值
//#include <stdio.h>
//int main()
//{
//	int arr[10] = { 0 };
//	int a = 0;
//	for (; a < 10; a++)
//	{
//		scanf("%d", &arr[a]);
//	}
//	int max = arr[0];
//	int b = 0;
//	for (; b < 10; b++)
//	{
//		if (arr[b]>max)
//			max = arr[b];
//	}
//	printf("%d", max);
//	return 0;
//}


////在屏幕上输出9*9乘法口诀表
//#include<stdio.h>
//int main()
//{
//	int i, j;
//	for (i = 1; i <= 9; i++)
//	{
//		for (j = 1; j <= i; j++)
//		{
//			printf("%d*%d=%-2d ", j, i, i*j);
//		}
//		printf("\n");
//	}
//	return 0;
//}

////编写代码在一个整形有序数组中查找具体的某个数
////要求：找到了就打印数字所在的下标，找不到则输出：找不到。
//#include <stdio.h>
//int main()
//{
//	int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//	int a = 0;
//	scanf("%d", &a);
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	int left = 0;
//	int right = sz - 1;
//	while (left <= right)
//	{
//		int mid = left + (right - left) / 2;
//		if (arr[mid] < a)
//		{
//			left = mid + 1;
//		}
//		else if (arr[mid] > a)
//		{
//			right = mid - 1;
//		}
//		else
//		{
//			printf("下标为:%d\n", mid);
//			break;
//		}
//	}
//	if (left > right)
//		printf("找不到\n");
//	return 0;
//}