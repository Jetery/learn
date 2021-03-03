#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
int main()
{
	int a = 3;
	int b = 5;
	printf("a=%d b=%d\n", a, b);
	//
	//交换两个整形的方法
	//

	////1.
	////创建临时变量
	//int temp = a;
	//a = b;
	//b = temp;

	////2.
	////通过加减 - 问题 - 有溢出的可能
	//a = a + b;
	//b = a - b;
	//a = a - b;

	//3.
	//异或操作符
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
	printf("a=%d b=%d\n", a, b);
	return 0;
}