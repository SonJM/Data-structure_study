#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
	int test_case, N_count, N[1001];

	scanf("%d", &test_case);
	for (int i = 0; i < test_case; i++)
	{
		int sum = 0, avr, count = 0;
		float result;
		scanf("%d", &N_count);
		for (int j = 0; j < N_count; j++)
		{
			scanf("%d", N + j);
			sum += N[j];
		}
		avr = sum / N_count;
		for (int k = 0; k < N_count; k++)
		{
			if (avr < N[k]) count++;
		}
		result = (float)(count * 100) / N_count;
		printf("%.3f%c\n", result, '%');
	}
}