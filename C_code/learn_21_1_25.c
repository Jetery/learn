#define _CRT_SECURE_NO_WARNINGS 1
/*
//每组7个分数（百分制），去掉一个最高分和一个最低分，输出每组的平均成绩
#include <stdio.h>
int main()
{
	int a[7];
	int flag = 1;
	scanf("%d %d %d %d %d %d %d", &a[0], &a[1], &a[2], &a[3], &a[4], &a[5], &a[6]);
	for (int i = 0; i<7 && flag; i++){
		flag = 0;
		for (int j = 0; j<7 - i; j++){
			int tmp = 0;
			if (a[j + 1]>a[j]){
				tmp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = tmp;
				flag = 1;
			}
		}
	}
	int sum = 0;
	for (int i = 1; i<6; i++){
		sum += a[i];
	}
	printf("%.2f\n", (float)sum / 5.0);
}
*/


/*
///输入年份和月份，计算这一年这个月有多少天。
#include<stdio.h>
int main()
{
	int year, month;
	while (scanf("%d %d", &year, &month) != EOF)
	{
		int runnian(int y);
		if (runnian(year) && month == 2)
			printf("29\n");
		else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			printf("31\n");
		else if (month == 2)
			printf("28\n");
		else
			printf("30\n");
	}
	return 0;
}
int runnian(int y)
{
	if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
		return 1;
	else
		return 0;
}
*/