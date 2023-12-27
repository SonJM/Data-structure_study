#include <stdio.h>
#include <stdlib.h>

//�����佺�׳׽��� ü : �뷮�� ���ڰ� �Ҽ����� �Ǻ��ϱ� ���� �˰���
#define MAX 1001    // MAX��� ��ũ�� ������� ��ũ�� Ȯ�� ���ڿ� 1001�� ġȯ

void eratos(int* arr);

int main(int argc, char** argv) {       // int argc : main�Լ��� ���޵Ǵ� ������ ����
                                        // char** argv : main�Լ��� ���������� ���޵Ǵ� ������ ����������
    int num = 1;
    int* arr = (int*)malloc(sizeof(int) * MAX);     // malloc�� �̿��� ���� �Ҵ� ������
                                                        // void* malloc(size_t size)
                                                        // size_t size -> �Ҵ��� �޸��� ũ�� ���� : sizeof(int) * MAX = 4 * 1000 = 4004(byte)
                                                        // int* : ��ȯ���� int�� ������ (���� ����ȯ) : ĳ���� �λ���
                                                    // malloc, free vs new, delete -> ������, �Ҹ����� �ڵ� ȣ��

    for (int i = 2; i < MAX; i++) {
        arr[i] = i;                                 // arr[] �迭�� 2~1000������ ���ڰ� �Էµ� '����' �迭
    }

    eratos(arr);

    free(arr);      // arr�� �Ҵ�� �޸� ���� (��ȯ)
    return 0;
}

void eratos(int* arr) {
    for (int i = 2; i < MAX; i++) {     // i���� ĭ�� �����Ͱ� 0�϶� continue
        if (arr[i] == 0) continue;

        for (int j = i * i; j < MAX; j += i) {      // i�� ����� �� = 0 -> n�� ����� �Ҽ��� �ƴϱ� ������ 0 ����
            arr[j] = 0;
        }
    }

    printf("�Ҽ�ã��\n");
    for (int i = 2; i < MAX; i++) {
        if (arr[i] != 0) printf("%d ", arr[i]);     // �Ҽ��� ���� ���
    }
}
