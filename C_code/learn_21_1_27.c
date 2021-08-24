#define _CRT_SECURE_NO_WARNINGS 1

/*
//递归方式实现打印一个整数的每一位数
#include <stdio.h>
void print(int x)
{
	if (x>9)
	{
		print(x / 10);
	}
	printf("%d ", x % 10);//如果printf放在if条件里则会丢失最高位
}
int main()
{
	int a = 0;
	scanf("%d", &a);
	print(a);
	return 0;
}
*/

//递归和非递归分别实现求n的阶乘
/*
//1
//非递归
#include <stdio.h>
int main()
{
	int a = 0;
	int b = 1;
	int x = 0;
	scanf("%d", &x);
	for (a = 1; a <= x; a++)
	{
		b = a * b;
	}
	printf("%d\n", b);
	return 0;
}
*/
/*
//2
//递归
#include <stdio.h>
int work(int x)
{
	if (x == 1)
	{
		return 1;
	}
	else if(x > 1)
	{
		return x*work(x-1);
	}
}
int main()
{
	int num = 0;
	scanf("%d", &num);
	int result = 0;
	result = work(num);
	printf("%d\n", result);
	return 0;
}
*/

//strlen的模拟
//递归和非递归分别实现strlen

/*
//1
//非递归
#include <stdio.h>
int my_strlen(char* str)
{
	int num = 0;
	while (*str != '\0')
	{
		num++;
		str++;
	}
	return num;
}
int main()
{
	char arr[] = "abcdef";
	int i = 0;
	i = my_strlen(arr);
	printf("%d\n", i);
	return 0;
}
*/
/*
//2
//递归
#include <stdio.h>
int my_strlen(char* str)
{
	if (*str == '\0')
	{
		return 0;
	}
	else
	{
		return 1 + my_strlen(str + 1);
	}
}
int main()
{
	char arr[] = "abcdef";
	int i = 0;
	i = my_strlen(arr);
	printf("%d\n", i);
	return 0;
}
*/

/*
//编写一个函数 reverse_string(char * string)（递归实现）
//实现：将参数字符串中的字符反向排列，不是逆序打印。
//要求：不能使用C函数库中的字符串操作函数

#include <stdio.h>
void reverse_string(char* string)
{
	if (*string != '\0')
	{
		reverse_string(string + 1);
	}
	printf("%c", *string);
}
int main()
{
	char arr[] = "abcdef";
	reverse_string(arr);
	return 0;
}
*/


/*
//编写一个函数实现n的k次方，使用递归实现
#include<stdio.h>
int act(int n, int k)
{
	if (k == 0)
	{
		return 1;
	}
	if (k == 1)
	{
		return n;
	}
	else
	{
		return n*act(n, k - 1);
	}
}
int main()
{
	int n, k;
	printf("请输入底数：\n");
	scanf("%d", &n);
	printf("请输入指数：\n");
	scanf("%d", &k);
	int answer = act(n, k);
	printf("%d", answer);
	return 0;

}
*/

/*
//递归和非递归分别实现求第n个斐波那契数
//1
//非递归
int fib(int x)
{
	int a = 1;
	int b = 1;
	int c = 0;
	while (x > 2)
	{
		c = a + b;
		a = b;
		b = c;
		x--;
	}
	return c;
}
int main()
{
	int n = 0;
	scanf("%d", &n);
	n = fib(n);
	printf("%d\n", n);
	return 0;
}
*/

/*
//2
//递归
#include <stdio.h>
int fib(int n)
{
	if ((n == 1) || (n == 2))
	{
		return 1;
	}
	if (n > 2)
	{
		return fib(n - 1) + fib(n - 2);
	}
}
int main()
{
	int n = 0;
	scanf("%d", &n);
	printf("%d\n", fib(n));
	return 0;
}
*/


//写一个递归函数DigitSum(n)，输入一个非负整数，返回组成它的数字之和
//例如，调用DigitSum(1729)，则应该返回1+7+2+9，它的和是19
#include <stdio.h>
int DigitSum(int x)
{
	if (x > 9)
	{
		return (x % 10) + DigitSum(x / 10);
	}
	else
		return x;
}
int main()
{
	int a = 0;
	scanf("%d", &a);
	int b = 0;
	b = DigitSum(a);
	printf("%d\n", b);
	return 0;
}
