// for���� �̿��ؼ� ������ �� �����ϱ�	
// ����: 1	����: 3	����: 1~6���� ������ ��
// �Է�: 1 3		���: 1093

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <cmath>		// pow ��� �Լ� ����ϱ� ���� ȣ��

int main() {
	int a, b;
	int sum = 0;
	scanf("%d %d", &a, &b);
	for (int i = 0; i < 7; i++) {
		sum += a * pow(b, i);	
									// �������� ��: a + ar + ar^2 + ar^3 + ...
									// C������ pow�Լ� ���� -> double pow(double base, double n) -> base�� n�� ������ �� ��ȯ
									/*	C++������ pow�Լ� ����
										1. double        pow(double base, double n)
										2. float           pow(float base, float n)
										3. long double pow(long double base, long double n)*/
	}
	printf("%d \n", sum);
}