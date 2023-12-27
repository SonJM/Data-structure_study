#include <iostream>

using namespace std;

int main()
{
	int A, B, C;
	int n = 0;
	int sum = 0;

	cin >> A >> B;
	cin >> C;

	n = (B + C) / 60;
	sum = B + C;

	while(true)
	{
		if (n > 0)
		{
			sum -= 60;
			A += 1;
			if (A == 24)
			{
				A = 0;
			}
			n--;
		}
		else break;
	}

	B = sum;
	cout << A << " " << B;
}	