#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main()
{
	int num;
	char ox[80] = { 0, };

	scanf("%d", &num);
	for (int i = 0; i < num; i++)
	{
		int result = 0, temp = 1;
		scanf("%s", &ox);
		for (int j = 0; j < strlen(ox); j++)
		{
			if (ox[j] == 'O')
			{
				result += temp;
				temp++;
			}
			else if (ox[j] == 'X')
				temp = 1;
		}
		printf("%d\n", result);
	}
}