#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROW 9
#define COL 9
#define ROWS ROW+2
#define COLS COL+2

//�׵�����
#define EASY_NUM 80

//��ʼ������
void InitBoard(char board[ROWS][COLS], int rows, int cols, char c);

//��ӡ����
void DisplayBoard(char board[ROWS][COLS], int row, int col);

//������
//mine  �洢����Ϣ
//row - ����
//col - ����
//count - �׵�����
void SetMine(char board[ROWS][COLS], int row, int col,int count);

//����
void FindCount(char mine[ROWS][COLS],
	char show[ROWS][COLS], 
	int row, int col, 
	int count);