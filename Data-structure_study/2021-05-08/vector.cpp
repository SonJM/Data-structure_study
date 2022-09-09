#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a, int b);
int binsearch(vector<int> v, int key);

int main() {
    int index;
    int key;
    int findNum;

    vector<int> v;

    printf("insert key(if key = 0 : break)\n");
    while (1) {
        scanf("%d", &key);
        if (key == 0) break;
        v.push_back(key);       // ������ ��ġ�� key �� �߰�
    }
    sort(v.begin(), v.end(), compare);      // v vertor�� compare �Լ� �������� ����
    v.erase(unique(v.begin(), v.end()), v.end());   // �ߺ��Ǵ� �� ����
    cout << endl;
    cout << "show. sort vector" << endl;
    for (int i = 0; i < v.size(); i++) {
        cout << "v[" << i << "] = " << v[i] << " ";
    }

    cout << endl;

    do {

        printf("find num(if num = 0 :break)\n");
        scanf("%d", &findNum);
        index = binsearch(v, findNum);      // ã������ ������ index��

        if (findNum != 0) {
            if (index == -1) {
                printf("not found!\n");
            }
            else {
                printf("find index : %d\n", index);
            }
        }

    } while (findNum != 0);
    v.clear();      // ��� �� ����
    printf("clear program\n");

    return 0;
}

bool compare(int a, int b) {
    return a < b;
}

int binsearch(vector<int> v, int key) {             // key(����)���� �Ű� ������ �޾Ƽ� v vector���� index���� ��ȯ�޴� �Լ�
    int low, high;
    int mid;

    low = 0;
    high = v.size();        // .size ���� ����
    while (low <= high) {
        mid = (low + high) / 2;
        if (key == v[mid]) {                        // �߾� index������ �񱳸� �ذ��� key�� �� => sort�� ���� ������ �Ǿ������Ƿ� ���Ʒ��� �����Ӱ� ������ �� ����.
            return mid;
        }
        else if (key < v[mid]) {
            high = mid - 1;
        }
        else if (key > v[mid]) {
            low = mid + 1;
        }
    }
    return -1;
}