// ������
// ������ ���� ptr �� int Ÿ���� num ������ �����Ͽ�, ptr ���� ����Ͻÿ�. (��, �޸𸮰��� ������ �ȵ˴ϴ�.
// ���� - 12 �� ���;��ϴµ�, 14023808 �̷������� ������ �ȵ˴ϴ�.)
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int num;
	int* ptr = &num;

	scanf("%d", &num);
	printf("ptr -> %d", *ptr);
}