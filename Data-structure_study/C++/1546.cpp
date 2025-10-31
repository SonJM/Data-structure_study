#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main()
{
	int N, M = 0;
	float AVR, grade[1001], SUM = 0;
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%f", &grade[i]);
	}
	
	M = grade[0];
	for (int i = 1; i < N; i++)
	{
		if (M < grade[i])
			M = grade[i];
	}

	for (int i = 0; i < N; i++)
	{
		grade[i] = (grade[i] / M) * 100;
		SUM += grade[i];
	}
	AVR = SUM / (float)N;
	printf("%f", AVR);
}