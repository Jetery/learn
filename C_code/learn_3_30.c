#define _CRT_SECURE_NO_WARNINGS 1



//模拟实现库函数strcpy
#include <stdio.h>
char* my_strcpy(char* aim, const char* temp)
{
	char* ret = *aim;
	while (*aim++ = *temp++)
	{
		;
	}
	return ret;
}


//模拟实现库函数strlen
int my_strlen(char* str)
{
	int ret = 0;
	while (*str++)
	{
		ret++;
	}
	return ret;
}



int main()
{
	char Str[100];
	char Hello[] = "Hello World!";
	my_strcpy(Str, Hello);
	printf("%d\n", my_strlen(Hello));
	//printf("%s\n", Str);
	return 0;
}