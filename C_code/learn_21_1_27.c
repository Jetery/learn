#define _CRT_SECURE_NO_WARNINGS 1

/*
//�ݹ鷽ʽʵ�ִ�ӡһ��������ÿһλ��
#include <stdio.h>
void print(int x)
{
	if (x>9)
	{
		print(x / 10);
	}
	printf("%d ", x % 10);//���printf����if��������ᶪʧ���λ
}
int main()
{
	int a = 0;
	scanf("%d", &a);
	print(a);
	return 0;
}
*/

//�ݹ�ͷǵݹ�ֱ�ʵ����n�Ľ׳�
/*
//1
//�ǵݹ�
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
//�ݹ�
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

//strlen��ģ��
//�ݹ�ͷǵݹ�ֱ�ʵ��strlen

/*
//1
//�ǵݹ�
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
//�ݹ�
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
//��дһ������ reverse_string(char * string)���ݹ�ʵ�֣�
//ʵ�֣��������ַ����е��ַ��������У����������ӡ��
//Ҫ�󣺲���ʹ��C�������е��ַ�����������

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
//��дһ������ʵ��n��k�η���ʹ�õݹ�ʵ��
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
	printf("�����������\n");
	scanf("%d", &n);
	printf("������ָ����\n");
	scanf("%d", &k);
	int answer = act(n, k);
	printf("%d", answer);
	return 0;

}
*/

/*
//�ݹ�ͷǵݹ�ֱ�ʵ�����n��쳲�������
//1
//�ǵݹ�
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
//�ݹ�
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


//дһ���ݹ麯��DigitSum(n)������һ���Ǹ����������������������֮��
//���磬����DigitSum(1729)����Ӧ�÷���1+7+2+9�����ĺ���19
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
