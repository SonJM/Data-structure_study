#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

void swap(int* arr, int a, int b);

int main() {
	int arr[101];
	int N, M, a, b;

	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++)
		arr[i] = i+1;

	for (int i = 0; i < M; i++)
	{
		scanf("%d %d", &a, &b);
		swap(arr, a, b);
	}

	for (int i = 0; i < N; i++)
		printf("%d ", arr[i]);
}

void swap(int* arr, int a, int b) {
	int temp = 0;

	temp = arr[a - 1];
	arr[a - 1] = arr[b - 1];
	arr[b - 1] = temp;
}