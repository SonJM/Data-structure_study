#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

int main() {
	int a, b, count = 0;
	int arr[100];

	scanf("%d", &a);
	for (int i = 0; i < a; i++)
	{
		scanf("%d", arr + i);
	}
	scanf("%d", &b);
	for (int i = 0; i < a; i++)
	{
		if (arr[i] == b) count++;
	}
	printf("%d", count);
}