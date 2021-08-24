#define _CRT_SECURE_NO_WARNINGS 1
//编写一个函数 reverse_string(char* string)（递归实现）
//实现：将参数字符串中的字符反向排列，不是逆序打印
//要求：不能使用C函数库中的字符串操作函数

#include <stdio.h>
#include<string.h>
////非递归版
//void reverse_string(char* string)
//{
//	char* left = string;
//	char* right = string + strlen(string) - 1;
//	//printf("%c", *left);
//	while (left < right)
//	{
//		char temp = *left;
//		*left = *right;
//		*right = temp;
//		left++;
//		right--;
//	}
//}
////递归版
void reverse_string(char* string)
{
	int len = strlen(string);
	char temp = *string;
	*string = *(string + len - 1);
	*(string + len - 1) = '\0';
	if (strlen(string + 1) > 2)
	{
		reverse_string(string+1);
	}
	*(string + len - 1) = temp;
}
int main()
{
	char arr[] = "abcdef";
	reverse_string(arr);
	printf("%s", arr);
	return 0;
}