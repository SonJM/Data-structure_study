#include <iostream>

using namespace std;
// �Է� �޴� �Ű� ���� a b���� ū ������ ���� ���� ������ ������ ��쿣 ū �� ���
// �ƴ� ��쿣 a * b ��� => a, b�� �ּҰ���� ���ϴ� ��
int function1(int a, int b) {
    if (b == 0) return a;
    else {
        return function1(b, a % b);         // function1�� ����Լ� -> �������� 0�� �� ������ ����
    }
}

int main() {
    ios_base::sync_with_stdio(false);       // c�� stdio�� cpp�� iostram�� ����ȭ�� ��Ȱ��ȭ ��Ų��.
                                            // ��? -> ios_base::sync_with_stdio ������ stdio�� iotream�� ����ȭ �����ִµ�
                                            //        �� �� iostram�� stdio�� ���۸� ��� ����ϱ� ������ �����̰� �߻��Ѵ�. �̸� ���� ����'
                                            // c++���� �������� ���۰� �����Ǿ� c�� ���ۿ� �����Ͽ� ��� X -> ���� �ӵ��� ��������
    cin.tie(NULL);                          // cin�� cout�� ������ Ǯ���ش�,,?
                                            // �ӵ� ����� ���� �Է°� ����� �����Ƽ� �ݺ��ؾ� �ϴ� ��� �ʼ����̴�

    int N, A, B, k;
    cin >> N;   // �ݺ� Ƚ��
    for (int i = 0; i < N; i++) {
        cin >> A >> B;
        k = function1(B, A);                // ����� �� ã�� : k�� 1�� �ƴ� ��찡 ������? -> �� ���� �� ������ ������ ���!!!!!
        cout << k * (A / k) * (B / k) << '\n';      //  �Է¹��� �� �� A�� B�� �ּҰ������ ���ϴ� ���̴�
    }
}