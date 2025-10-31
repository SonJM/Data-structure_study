#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int arr[30];
	int num;

	for (int i = 0; i < 30; i++)
		arr[i] = i + 1;

	for (int i = 0; i < 28; i++)
	{
		scanf("%d", &num);
		for(int j = 0; j < 30; j++)
			if (arr[j] == num) arr[j] = 0;
	}

	for (int i = 0; i < 30; i++)
	{
		if (arr[i] != 0) printf("%d\n", arr[i]);
	}

}