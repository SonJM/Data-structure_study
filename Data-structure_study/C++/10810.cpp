#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

int main() {
	int arr[1001] = { 0, };
	int N, M;
	int a, b, c;

	scanf("%d %d", &N, &M);

	for (int i = 0; i < M; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		int num = b - a + 1;
		for (int x = 0; x < num; x++, a++)
		{
			arr[a - 1] = c;
		}
		
	}

	for (int i = 0; i < N; i++)
	{
		printf("%d ", arr[i]);
	}
}