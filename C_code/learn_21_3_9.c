#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

//
//#pragma pack(8)  //默认值为8
//struct U1
//{
//	char a;
//	int b;
//	char c;
//};
//#pragma pack()  //取消默认参数
//
//#pragma pack(1)  //默认值为1
//struct U2
//{
//	char a;
//	int b;
//	char c;
//};
//#pragma pack()  //取消默认参数
//
//int main()
//{
//	printf("未修改：%d\n", sizeof(struct U1));
//	printf("修改后：%d\n", sizeof(struct U2));
//	return 0;
//}

struct S
{
	int data[1000];
	int num;
};

//struct S s = { { 1, 2, 3, 4 }, 1000 };
//
////结构体传参
//void print1(struct S s)
//{
//	printf("%d\n", s.num);
//}
//
////结构体地址传参
//void print2(struct S* ps)
//{
//	printf("%d\n", ps->num);
//}
//int main()
//{
//	print1(s);
//	print2(&s);
//	return 0;
//}


//struct A
//{
//	int a : 2;
//	unsigned int b : 4;
//	signed int c : 10;
//	int d : 30;
//};

//int main()
//{
//	printf("%d\n", sizeof(struct A));
//	return 0;
//}

//enum Sex
//{
//	//枚举的可能取值
//	MALE,
//	FEMALE = 10,
//	SECRET
//};
//
//int main()
//{
//	enum Sex s = MALE;
//	printf("%d\n", MALE);
//	printf("%d\n", FEMALE);
//	printf("%d\n", SECRET);
//	return 0;
//}


//enum Choice
//{
//	exit,
//	add,
//	sub,
//	mul,
//	div
//};
//
//void menu()
//{
//	printf("*******************************\n");
//	printf("***** 1.add       2.sub   *****\n");
//	printf("***** 3.mul       4.div   *****\n");
//	printf("******0.exit              *****\n");
//	printf("*******************************\n");
//
//}
//
//void menu2()
//{
//	printf("请输入两个数:>");
//}
//
//int ADD(int x,int y)
//{
//	return x + y;
//}
//
//int SUB(int x, int y)
//{
//	return x - y;
//}
//
//int MUL(int x, int y)
//{
//	return x * y;
//}
//
//int DIV(int x, int y)
//{
//	return x / y;
//}
//
//int main()
//{
//	int intput = 0;
//	int x = 0;
//	int y = 0;
//	int z = 0;
//	do
//	{
//		menu();
//		printf("choose:>");
//		scanf("%d", &intput);
//		menu2();
//		switch (intput)
//		{
//		case add:
//			scanf("%d%d", &x, &y);
//			z = ADD(x, y);
//			break;
//		case sub:
//			scanf("%d%d", &x, &y);
//			z = SUB(x, y);
//			break;
//		case mul:
//			scanf("%d%d", &x, &y);
//			z = MUL(x, y);
//			break;
//		case div:
//			scanf("%d%d", &x, &y);
//			z = DIV(x, y);
//			break;
//		case exit:
//			printf("退出程序。\n");
//			break;
//		default:
//			printf("输入错误，请重新输入！\n");
//			break;
//		}
//		printf("%d\n", z);
//	} while (intput);
//	return 0;
//}


union A
{
	char c[7];
	int i;
};



int main()
{
	union A a;
	printf("%d\n", sizeof(a));
	return 0;
}