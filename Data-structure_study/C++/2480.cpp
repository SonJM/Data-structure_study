#include <iostream>

int* sort(int* arr) {
	int temp = arr[0];

	if (temp > arr[1]) 
	{
		arr[0] = arr[1];
		arr[1] = temp;
		if (temp > arr[2])
		{
			arr[1] = arr[2];
			arr[2] = temp;
		}
	}
	else if (temp <= arr[1])
	{
		if (arr[1] > arr[2])
		{
			temp = arr[1];
			arr[1] = arr[2];
			arr[2] = temp;
			if (arr[0] != arr[1])
			{
				temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			}
		}
	}

	return arr;
}

int main()
{
	int* arr;
	int dice[3] = { 0, };
	int result = 0;

	for (int i = 0; i < 3; i++)
	{
		std::cin >> dice[i];
	}

	arr = sort(dice);

	if (arr[0] == arr[1] && arr[1] == arr[2])
		result = 10000 + (arr[0] * 1000);
	else if (arr[0] == arr[1] || arr[1] == arr[2])
		result = 1000 + (arr[1] * 100);
	else if (arr[0] != arr[1] && arr[1] != arr[2])
		result = arr[2] * 100;

	std::cout << result;
}