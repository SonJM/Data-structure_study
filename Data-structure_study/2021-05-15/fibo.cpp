#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h> 
// �ѹ� ���� ���� ������ �迭 ������ ���� DP�� �ι�° ������ �������������ν� ��� �ӵ� ����
int d[100];      // ��� �迭�� �� 0 ���� �ʱ�ȭ => �޸������̼� ���

int function(int num) {
    if (num == 1) return 1;
    if (num == 2) return 1;
    if (d[num] != 0) return d[num];
    return d[num] = function(num - 1) + function(num - 2);        // �Ǻ���ġ ������ ��ȭ��
                                                         // �Ǻ���ġ ���� : Ư���� ���ڸ� ���ϱ� ���� �� �տ� �ִ� ���ڿ� �� ĭ �տ� �ִ� ������ ��
}

int main() {
    int num = 0;
    scanf("%d", &num);

    printf("fibo index :%d and result = %d\n", num, function(num));

    return 0;
}
