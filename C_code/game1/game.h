#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROW 3
#define COL 3

//��ʼ������
void InitBoard(char Board[ROW][COL],int row,int col);


//��ӡ����
void DisplayBoard(char Board[ROW][COL], int row, int col);


//������ӣ�*��
void PlayerMove(char Board[ROW][COL], int row, int col);

//�������ӣ�#��
void ComputerMove(char Board[ROW][COL], int row, int col);

//�ж���Ӯ
char CheckWin(char Board[ROW][COL], int row, int col);
//����'*'  ���ʤ��
//����'#'  ����ʤ��
//����'Q'  ƽ��
//����'C'  ������Ϸ

