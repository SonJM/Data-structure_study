// ������
// call by address �� �̿��ؼ� ����� �����Լ��� �̸��� swap���� �� �ΰ�, �� ������ ���� �Է� �޾� ����Ͻÿ�
// ���� �Է� : 5 10		��� : 10 5
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void swap(int* a, int* b) {
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

int main() {
	int a, b;
	scanf("%d %d", &a, &b);
	swap(&a, &b);
	printf("%d %d", a, b);
}