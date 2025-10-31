#include <iostream>
#include <stdlib.h>

using namespace std;

int main()
{
	int SUM, n;
	int temp = 0;

	cin >> SUM;
	cin >> n;
	int* a = (int*)malloc(sizeof(int) * n);
	int* b = (int*)malloc(sizeof(int) * n);
	for (int i = 0; i < n; i++)
	{
		cin >> a[i] >> b[i];
		temp += a[i] * b[i];
	}
	
	if (SUM == temp)
		cout << "Yes";
	else cout << "No";

	free(a);
	free(b);
}