// 7���� �ڿ����� �־��� ��, �̵� �߿��� Ȧ���μ� ���� ū ���� ¦���μ� ���� ū ���� ���� ã�� �� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

#define _CRT_SECURE_NO_WARNINGS
#define LENGTH 7
#include <stdio.h>

int main() {
	int arr[LENGTH];
	int temp;

	for (int i = 0; i < LENGTH; i++) {
 		scanf("%d", arr + i);
	}
	// Bubble Sort
	for (int i = 0; i < LENGTH - 1; i++) {	// �� ���� ���� �����ص� �� ������ ���Ұ� �����Ƿ� �����ʿ�x
		for (int j = 0; j < LENGTH - 1 - i; j++) {	// �񱳴� 0���� �����ؾ� �ϹǷ�
			if (*(arr + j) > *(arr + j + 1)) {
				//�տ����� ũ�� swap
				temp = *(arr + j);
				*(arr + j) = *(arr + j + 1);
				*(arr + j + 1) = temp;
			}
		}
	}

	if (arr[6] % 2 == 0 && arr[5] % 2 == 0) printf("%d", arr[6]);
	else if (arr[6] % 2 == 1 && arr[5] % 2 == 1) printf("%d", arr[6]);
	else printf("%d", arr[5] + arr[6]);
}