// �����Ҵ�
// �����Ҵ� �迭�� stack �� queue�� �����Ϸ��� �Ѵ�. ������ ������ ����.

/*1. �����Ҵ����� �迭�� ���� ��, ������ ���� �ִ´�.
	2. Ȧ���̸� stack�� , ¦���̸� queue�� �������� �Ѵ�.
	3. stack �� queue ���� �����Ҵ����� ���� �迭�ȿ� �����ϸ�, ���� 2�������� �ݵ�� �������Ѿ� �Ѵ�.
	4. stack ��� , queue ����� �ݺ��Ѵ�. (��, stack �Ǵ� queue�� ����� ������ �� ���Ŀ��� stack �� queue �迭 �� ���� �� ������� ���� �迭�� �״�� �� ����Ѵ�.*/

#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

int main() {
	int num, i = 0;
	int a = 0, b = 0;

	scanf("%d", &num);

	int* arr = (int*)malloc(sizeof(int) * num);
	for (int i = 0; i < num; i++) {
		scanf("%d", arr + i);
	}

	int stack[100];	int queue[100];

	for (i = 0; i < num; i++) {
		if (arr[i] % 2 == 1) {
			stack[a] = arr[i];
			a++;
		}
		if (arr[i] % 2 == 0) {
			queue[b] = arr[i];
			b++;
		}
	}

	for (i = 0; i < num/2; i++) {
		if (*(stack + i) == NULL || *(queue + i) == NULL) break;
		printf("%d ", *(stack + i));
		printf("%d ", *(queue + i));
	}

	free(arr);
}