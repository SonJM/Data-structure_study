#include <iostream>
#include <stdlib.h>

using namespace std;

int main() {
	int N, result;
	int sum = 0;

	cin >> N >> result;
	
	int* M = (int*)malloc(sizeof(int) * N);
	for (int i = 0; i < N; i++) {
		cin >> M[i];
	}

	for (int i = 0; i < N - 2; i++) {
		for (int j = i + 1; j < N - 1; j++) {
			for (int k = j + 1; k < N; k++) {
				if (M[i] + M[j] + M[k] <= result && result - (M[i] + M[j] + M[k]) < result - sum )	
					sum = M[i] + M[j] + M[k];
				}
			}
		}
	cout << sum;
}