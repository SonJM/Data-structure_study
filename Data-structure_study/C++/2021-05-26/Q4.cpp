// ����� ���� �Լ�
// ����� ���� �Լ��� �����Ͽ�, 1���� 20������ ���� �����Ͽ� ���� ����϶�

#include <stdio.h>

int function(int n) {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		sum += i;
	}
	return sum;
}

int main() {
	printf("%d\n", function(20));
	return 0;
}