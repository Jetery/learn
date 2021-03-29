#define _CRT_SECURE_NO_WARNINGS 1
/*
//Aim:
//写一个函数打印arr数组的内容，不使用数组下标，使用指针。
//Derection:
//arr是一个整形一维数组。
#include <stdio.h>
#include <stdlib.h>
void print(int arr[], int i)
{
	int* p = arr;
	for (int a = 0; a < i; a++)
	{
		printf("%d ", *(p + a));
	}
	printf("\n");
}


int main()
{
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int i = sizeof(arr) / sizeof(arr[0]);
	print(arr,i);
}
*/



/*
//将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
//输入描述:
//	输入一个字符串，可以有空格
//输出描述:
//	输出逆序的字符串
#include <stdio.h>
#include <string.h>

void reverse(char* str)
{
	int len = strlen(str);
	char* left = str;
	char* right = str + len - 1;
	while (left < right)
	{
		char* temp = *left;
		*left = *right;
		*right = temp;
		left++;
		right--;
	}
}


int main()
{
	char str[100];
	gets(str);
	reverse(str);
	printf("%s\n", str);
	return 0;
}
*/



/*
//求Sn=a+aa+aaa+aaaa+aaaaa的前5项之和，其中a是一个数字
//例如：2 + 22 + 222 + 2222 + 22222
#include <stdio.h>
int main()
{
	int a;
	int b = 1;
	scanf("%d", &a);
	int c = a;
	int i;
	int sum = 0;
	for (i = 0; i < 5; i++)
	{
		c = a * b;
		b = b * 10 + 1;
		sum += c;
	}
	printf("%d\n", sum);
	return 0;
}
*/




/*
//求出0～100000之间的所有“水仙花数”并输出。
//“水仙花数”是指一个n位数，其各位数字的n次方之和确好等于该数本身
//如:153＝1 ^ 3＋5 ^ 3＋3 ^ 3，则153是一个“水仙花数”。
#include <stdio.h>
#include <math.h>
int main()
{
	for (int i = 0; i <= 100000; i++)
	{
		int n = 0;//最少是一位数
		int temp = i;
		int sum = 0;
		//先得到几位数(n)
		while (temp)
		{
			temp /= 10;
			n++;
		}
		temp = i;
		while (temp)
		{
			int a = temp % 10;
			sum += pow(a, n);
			temp /= 10;
		}
		if (sum == i)
		{
			printf("%d ", i);
		}
	}
	return 0;
}
//int n = 0;若放在for循环外，则再别的循环中，n的值仍然保留上一次
*/


/*
//用C语言在屏幕上输出菱形
#include <stdio.h>
int main()
{
	int i;int j;
	int n = 13;
	//scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		for (j = i; j < n-1; j++)
		{
			printf(" ");
		}
		for (j = 0; j < i * 2 + 1; j++)
		{
			printf("*");
		}
		printf("\n");
	}
	for (i = n - 2; i >= 0; i--)
	{
		for (j = i; j < n - 1; j++)
		{
			printf(" ");
		}
		for (j = 0; j < i * 2 + 1; j++)
		{
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
*/


//喝汽水，1瓶汽水1元，2个空瓶可以换一瓶汽水，给20元，可以多少汽水（编程实现）。
#include <stdio.h>
#define MONEY 20
int main()
{
	int n = MONEY;//钱不是关键，全部用瓶子来算
	int count = MONEY;//喝汽水数
	int empty = 0;
	while (n / 2)
	{
		empty = n % 2;
		n /= 2;
		count += n;
		n += empty;
	}
	printf("%d\n", count);
	return 0;
}
