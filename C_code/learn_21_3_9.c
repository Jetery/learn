#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>

//
//#pragma pack(8)  //Ĭ��ֵΪ8
//struct U1
//{
//	char a;
//	int b;
//	char c;
//};
//#pragma pack()  //ȡ��Ĭ�ϲ���
//
//#pragma pack(1)  //Ĭ��ֵΪ1
//struct U2
//{
//	char a;
//	int b;
//	char c;
//};
//#pragma pack()  //ȡ��Ĭ�ϲ���
//
//int main()
//{
//	printf("δ�޸ģ�%d\n", sizeof(struct U1));
//	printf("�޸ĺ�%d\n", sizeof(struct U2));
//	return 0;
//}

struct S
{
	int data[1000];
	int num;
};

//struct S s = { { 1, 2, 3, 4 }, 1000 };
//
////�ṹ�崫��
//void print1(struct S s)
//{
//	printf("%d\n", s.num);
//}
//
////�ṹ���ַ����
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
//	//ö�ٵĿ���ȡֵ
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
//	printf("������������:>");
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
//			printf("�˳�����\n");
//			break;
//		default:
//			printf("����������������룡\n");
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