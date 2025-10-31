#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
	int arr[101];
	int N, M, a, b;

	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++)
		arr[i] = i + 1;

	for (int i = 0; i < M; i++)
	{
		scanf("%d %d", &a, &b);
		int num = (b - a) / 2 + 1; 
		for (int O = 0; O < num; O++, a++, b--)
		{
			int temp = 0;
			temp = arr[a - 1];
			arr[a - 1] = arr[b - 1];
			arr[b - 1] = temp;
		}
	}

	for (int i = 0; i < N; i++)
		printf("%d ", arr[i]);
}