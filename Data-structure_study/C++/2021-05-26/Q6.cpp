// ����� ���� �Լ�
// �Ǻ���ġ ���� 10��° ���� ����ϴ� ���α׷��� ����� ���� �Լ��� �̿��ؼ� ����ÿ�

#include <stdio.h>

int d[10];

int fibo(int n) {
	if (n == 1) return 1;
	if (n == 2) return 1;
	if (d[n] != 0) return d[n];
	return d[n] = fibo(n - 1) + fibo(n - 2);
}

int main() {
	printf("%d", fibo(10));
	return 0;
}