// ����� ���� �Լ�
// 1~50������ Ȧ���� ���� ����� �����Լ��� �̿��Ͽ� ���� �� ���ÿ�.

#include <stdio.h>

int function(int n) {
	int sum = 0;
	for (int i = 1; i <= n; i+=2) {
		sum += i;
	}
	return sum;
}

int main() {
	printf("%d\n", function(50));
	return 0;
}