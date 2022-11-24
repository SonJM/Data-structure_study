#include <stdio.h>

int main() {
	int arr[10001];
		
	for (int i = 0; i < 10000; i++)
	{
		arr[i] = i + 1;
		printf("%d\n", self_number(arr[i]));
	}
}

int self_number(int N)
{
	if (N == 0) 

	return self_number(N);
}