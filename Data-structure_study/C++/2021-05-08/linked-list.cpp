#include <stdio.h>
#include <stdlib.h>

// C++ ������ ����� ���� '���� ������ ����(user-defined aggregate data type)'�� ������ �� �ִ�.
// ���� ������ ���� : ���� ���� ������ �Բ� �׷�ȭ�ϴ� ������ ���� --> ����ü(struct)
// ����ü : �ϳ� �̻��� ������ �׷� ��� ���ο� �ڷ����� �����ϴ� �� ( ���, �ʵ� )
// C++ 11������ �ʱⰪ ���� ���ϸ� default������ �ʱ�ȭ, �� ������ ������ ���� ����
typedef struct stack {
    int data;
    struct stack* next;     
    struct stack* prev;
}stack;

typedef struct tree {
    struct stack* head;
    struct stack* tail;
    int count;
}tree;

tree* init() {
    tree* newTree = (tree*)malloc(sizeof(tree));        // sizeof(tree) = 12(byte) / newTree ����ü �����Ϳ� �޸� �Ҵ�

    newTree->head = NULL;
    newTree->count = 0;     
    // tail����ü �����Ϳ��� �ʱ�ȭ�� ���� �ʿ� ���°ǰ�,,?
    return newTree;
}

void push_stack(int data, tree* newTree);
stack* memclear(tree* newTree);
void print(tree* newTree);

int main(int argc, char** argv) {
    tree* newTree = init();
    for (int i = 0; i < 10; i++) {
        push_stack(i, newTree);     // 10�� push_stack�Ѵ�
    }
    print(newTree);

    printf("memory return\n");
    for (int i = 0; i < newTree->count; i++) {
        memclear(newTree);
    }
    free(newTree);      // memclear��ü�� �޸𸮸� ��ȯ�ϴ� �ڵ�� ������ �ʴ´�,,?

    return 0;
}

void push_stack(int data, tree* newTree) {
    stack* newStack = (stack*)malloc(sizeof(stack));
    stack* preStack = newTree->head;        // head = NULL

    newStack->data = data;

    if (newTree->count == 0) {
        newTree->head = newStack;
        newStack->next = newStack;
        newStack->prev = newStack;
    }
    else {
        for (int i = 1; i < newTree->count; i++) {
            preStack = preStack->next;
        }
        preStack->next = newStack;
        preStack->next->prev = preStack;
    }
    newTree->tail = newStack;
    newTree->count++;
}

stack* memclear(tree* newTree) {
    stack* curStack;
    curStack = newTree->head;
    newTree->head = curStack->next;
    return curStack;
}

void print(tree* newTree) {
    stack* curStack;
    int i;
    printf("���� �ڷᱸ���� LIFO (Last in First out)\n");
    for (i = 0, curStack = newTree->tail; i < newTree->count; i++, curStack = curStack->prev) {
        printf("%d ", curStack->data);
    }
    printf("\n");
}