#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
/*
//���������������в�ͬλ�ĸ���
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
//����һ���������������32λ�����Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
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


//��ӡ���������Ƶ�����λ��ż��λ
//��ȡһ���������������������е�ż��λ������λ���ֱ��ӡ������������
int main()
{
	int a;
	scanf("%d", &a);
	int i;
	printf("����λΪ��\n");
	for (i = 30; i >= 0; i -= 2)
	{
		printf("%d", (a >> i) & 1);
	}
	printf("\nż��Ϊ��\n");
	for (i = 31; i >= 1; i -= 2)
	{
		printf("%d", (a >> i) & 1);
	}
	printf("\n");
	return 0;
}
