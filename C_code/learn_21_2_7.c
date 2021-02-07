#define _CRT_SECURE_NO_WARNINGS 1
//将数组A中的内容和数组B中的内容进行交换。（数组一样大）
#include <stdio.h>
void change(int arr1[], int arr2[],int sz)
{
	int i = 0;
	for (i = 0; i < sz; i++)
	{
		int temp = arr1[i];
		arr1[i] = arr2[i];
		arr2[i] = temp;
	}
}
void print(int arr[], int sz)
{
	int i = 0;
	for (i = 0; i < sz; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
int main()
{
	int arr1[] = { 1, 2, 3, 4, 5 };
	int arr2[] = { 6, 7, 8, 9, 10 };
	int sz = sizeof(arr1) / sizeof(arr1[0]);
	change(arr1, arr2,sz);
	printf("arr1:\n");
	print(arr1,sz);
	printf("arr2:\n");
	print(arr2,sz);
	return 0;
}