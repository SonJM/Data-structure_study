#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main()
{
	int N, stack[10001] = { 0, }, count = 0;
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		char command[10];
		scanf("%s", command);
		if (strcmp("push", command) == 0)
		{
			int tmp;
			scanf("%d", &tmp);
			stack[count] = tmp;
			count++;
		}
		else if (strcmp("pop", command) == 0)
		{
			if (count == 0)
				printf("-1\n");
			else
			{
				count--;
				printf("%d\n", stack[count]);
				stack[count] = 0;
			}
		}
		else if (strcmp("size", command) == 0)
		{
			printf("%d\n", count);
		}
		else if (strcmp("empty", command) == 0)
		{
			if (count == 0)
				printf("1\n");
			else
				printf("0\n");
		}
		else if (strcmp("top", command) == 0)
		{
			if (count == 0)
				printf("-1\n");
			else
				printf("%d\n", stack[count - 1]);
		}
	}
}