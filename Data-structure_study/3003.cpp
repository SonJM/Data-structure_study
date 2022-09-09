#include <iostream>

using namespace std;

int main()
{
	int _in_pieces[6] = { 0, };
	int _out_pieces[6] = { 1,1,2,2,2,8 };
	int result[6] = { 0, };
	

	for (int i = 0; i < 6; i++)
	{
		cin >> _in_pieces[i];
	}
	for (int i = 0; i < 6; i++)
	{
		result[i] = _out_pieces[i] - _in_pieces[i];
		cout << result[i] << " ";
	}
}