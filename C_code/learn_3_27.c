#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
/*
//求两个数二进制中不同位的个数
int main()
{
	int a = 0;
	int b = 0;
	int c = 0;
	scanf("%d%d", &a, &b);
	c = a^b;
	int i = 0;
	int count = 0;
	for (i = 0; i<32; i++)
	{
		if ((c >> i) & 1 == 1)
		{
			count++;
		}
	}
	printf("%d\n", count);
	return 0;
}
*/


/*
//输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
class Solution {
public:
	int  NumberOf1(int n) {
		int i;
		int count = 0;
		for (i = 0; i<32; i++)
		{
			if ((n >> i) & 1 == 1)
			{
				count++;
			}
		}
		return count;
	}
};
*/


//打印整数二进制的奇数位和偶数位
//获取一个整数二进制序列中所有的偶数位和奇数位，分别打印出二进制序列
int main()
{
	int a;
	scanf("%d", &a);
	int i;
	printf("奇数位为：\n");
	for (i = 30; i >= 0; i -= 2)
	{
		printf("%d", (a >> i) & 1);
	}
	printf("\n偶数为：\n");
	for (i = 31; i >= 1; i -= 2)
	{
		printf("%d", (a >> i) & 1);
	}
	printf("\n");
	return 0;
}
