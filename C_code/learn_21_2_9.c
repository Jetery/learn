#define _CRT_SECURE_NO_WARNINGS 1
//��дһ������ reverse_string(char* string)���ݹ�ʵ�֣�
//ʵ�֣��������ַ����е��ַ��������У����������ӡ
//Ҫ�󣺲���ʹ��C�������е��ַ�����������

#include <stdio.h>
#include<string.h>
////�ǵݹ��
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
////�ݹ��
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