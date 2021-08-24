#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

//二维数组创建 arr[m][n],m为行数，n为列数
//二维数组创建时  给值  为初始化
/*
int main()
{
	int arr[3][5] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	return 0;
}
*/
//结果为1，2，3，4，5在第一行
//     6，7，8，9，10在第二行
//       第三行为空，全 0


////初始化
/*
int main()
{
	int arr[3][5] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10 } };
	return 0;
}
*/
//结果在第一行  1, 2, 3, 4, 0
//    在第二行  5, 6, 7, 8, 0
//    在第三行  9, 10, 0, 0, 0


//////初始化
/*
int main()
{
	int arr[][4] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }};
	return 0;
}
*/
//m(行数)可以省略，列数不可以，行数省略通过初始化内容来确定

//***************************************************************

//二维数组的使用:通过下标来访问，行列数全部从0开始
/*
int main()
{
	int arr[3][5] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int i = 0;
	for (i = 0; i < 3; i++)
	{
		int j = 0;
		for (j = 0; j < 5; j++)
		{
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
	return 0;
}
*/
//可以理解为arr[0]为第一行数组名


//***************************************************************
//二维数组内存的存储
/*
int main()
{
	int arr[3][4] = { 0 };
	int i = 0;
	for (i = 0; i < 3; i++)
	{
		int j = 0;
		for (j = 0; j < 4; j++)
		{
			printf("%p\n", &arr[i][j]);
		}
	}
	return 0;
}
*/
//result:
//0098FDD4
//0098FDD8
//0098FDDC
//0098FDE0
//0098FDE4
//0098FDE8
//0098FDEC
//0098FDF0
//0098FDF4
//0098FDF8
//0098FDFC
//0098FE00
//可见仍然成列存放


//通过地址名访问数组
/*
int main()
{
	int arr[3][4] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	int* p = &arr[0][0];
	int i = 0;
	for (i = 0; i < 12; i++)
	{
		printf("%d ", *(p + i));
	}
	return 0;
}
*/


//*
//冒泡排序
void BS(int* arr, int sz)
{
	int i = 0;
	for (i = 0; i < sz - 1; i++)//确定趟数
	{
		int flag = 1;//优化内容：局部顺序，防止无用替换（假设有序）
		int j = 0;
		for (j = 0; j < sz - 1 - i; j++)//每一趟排序
		{
			if (arr[j]>arr[j + 1])
			{
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				flag = 0;//优化内容（发现无序)
			}
		}
		if (1 == flag)//优化内容
			break;//优化结果：比而不换
	}
}
int main()
{
	int arr[10] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	int sz = 0;
	int i = 0;
	sz = sizeof(arr) / sizeof(arr[0]);
	printf("before:\n");
	for (i = 0; i < 10; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
	BS(arr, sz);
	printf("after:\n");
	for (i = 0; i < 10; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
	return 0;
}
//*/