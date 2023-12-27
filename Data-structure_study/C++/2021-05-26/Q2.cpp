// ����for���� �̿��ؼ� �����ڽ� �׸��� (��, ���� for���� 5x5 ��ķ� �����Ѵ�.)
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int num;
	scanf("%d", &num);	// �ݺ� Ƚ�� ����

	char** arr = (char**)malloc(sizeof(char*) * num);	// 2���� �迭 ���� �Ҵ�
	
	for (int i = 0; i < num; i++) {
		arr[i] = (char*)malloc(sizeof(char) * num);		// 2���� �迭 ���� �Ҵ�
	}

	for (int i = 0; i < num; i++) {
		for (int j = 0; j < num; j++) {
			if (i == j || i + j == num-1) arr[i][j] = '*';
			else if (i == 0 || j == 0 || i == num-1 || j == num-1) arr[i][j] = '*';
			else arr[i][j] = ' ';														// arr[i][j]�� ���ϴ� ����� �� ��� �Է�
		}
	}
	
	for (int i = 0; i < num; i++) {
		for (int j = 0; j < num; j++) {
			printf("%c", arr[i][j]);				// ���� for���� ���� 2���� �迭 ���
		}
		printf("\n");
	}

	for (int i = 0; i < num; i++) {
		free(arr[i]);								// 2���� �迭 �޸� ��ȯ
	}
	free(arr);

	return 0;

}