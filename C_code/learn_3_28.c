#define _CRT_SECURE_NO_WARNINGS 1
/*
//Aim:
//дһ��������ӡarr��������ݣ���ʹ�������±꣬ʹ��ָ�롣
//Derection:
//arr��һ������һά���顣
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
//��һ���ַ���str�����ݵߵ��������������str�ĳ��Ȳ�����100���ַ���
//��������:
//	����һ���ַ����������пո�
//�������:
//	���������ַ���
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
//��Sn=a+aa+aaa+aaaa+aaaaa��ǰ5��֮�ͣ�����a��һ������
//���磺2 + 22 + 222 + 2222 + 22222
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
//���0��100000֮������С�ˮ�ɻ������������
//��ˮ�ɻ�������ָһ��nλ�������λ���ֵ�n�η�֮��ȷ�õ��ڸ�������
//��:153��1 ^ 3��5 ^ 3��3 ^ 3����153��һ����ˮ�ɻ�������
#include <stdio.h>
#include <math.h>
int main()
{
	for (int i = 0; i <= 100000; i++)
	{
		int n = 0;//������һλ��
		int temp = i;
		int sum = 0;
		//�ȵõ���λ��(n)
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
//int n = 0;������forѭ���⣬���ٱ��ѭ���У�n��ֵ��Ȼ������һ��
*/


/*
//��C��������Ļ���������
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


//����ˮ��1ƿ��ˮ1Ԫ��2����ƿ���Ի�һƿ��ˮ����20Ԫ�����Զ�����ˮ�����ʵ�֣���
#include <stdio.h>
#define MONEY 20
int main()
{
	int n = MONEY;//Ǯ���ǹؼ���ȫ����ƿ������
	int count = MONEY;//����ˮ��
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
