#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
void BS(int a[], int len)
{
	int i, j, temp;
	for (j = 0; j < len - 1; j++)
	{
		for (i = 0; i < len - 1 - j; i++)
		if (a[i] > a[i + 1])
		{
			temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
		}
	}
}
int main()
{
	int arr[] = { 5, 1, 7, 8, 6, 3, 9, 4, 2, };
	int len = sizeof(arr) / sizeof(arr[0]);
	int i = 0;
	printf("before:\n");
	for (i = 0; i < len; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
	BS(arr, len);
	printf("after:\n");
	for (i = 0; i < len; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
	return 0;
}