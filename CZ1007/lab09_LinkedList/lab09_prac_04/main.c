// CE1007/CZ1007 Data Structures
// Week 10 Lab Tutorial - Linked List

#include <stdio.h>
#include <stdlib.h>

typedef struct _listnode{
	int num;
	struct _listnode *next;
} ListNode;

typedef struct _dbllistnode{
	int num;
	struct _dbllistnode *pre;
	struct _dbllistnode *next;
} DblListNode;

DblListNode * findNode(DblListNode *head, int index);
int insertDbl(DblListNode **ptrHead, int index, int value);
void printDblList(DblListNode *head);

int main()
{
	DblListNode *dblHead = NULL;

	printf("insertDbl()\nDoubly-linked list: ");
	insertDbl(&dblHead, 0, 10);
	insertDbl(&dblHead, 0, 20);
	insertDbl(&dblHead, 1, 30);
	insertDbl(&dblHead, 2, 40);
	printDblList(dblHead);
	return 0;
}

void printDblList(DblListNode *head){
	if (head == NULL) return;
	while (head != NULL){
		printf("%d ", head->num);
		head = head->next;
	}
	printf("\n");
}

DblListNode * findNode(DblListNode *head, int index){
	if (head == NULL || index < 0) return NULL;
	while (index > 0){
		head = head->next;
		if (head == NULL)
			return NULL;
		index--;
	}
	return head;
}

int insertDbl(DblListNode **ptrHead, int index, int value){
	// write your code here
    DblListNode *newNode = malloc(sizeof(ListNode)), *preNode, *curNode;
    if (newNode == NULL || index < 0)  // failed malloc or invalid index
        return -1;
    newNode->num = value;

    if (*ptrHead == NULL){  // no nodes
        *ptrHead = newNode;
        newNode->pre = NULL;
        newNode->next = NULL;
    } else {
        // at least one node(s) in list
        if (index == 0){
            newNode->pre = NULL;
            newNode->next = *ptrHead;
            (*ptrHead)->pre = newNode;
            *ptrHead = newNode;
        } else {
            preNode = findNode(*ptrHead, index-1);
            if (preNode == NULL)
                return -1;
            else {
                curNode = preNode->next;
                preNode->next = newNode;
                newNode->pre = preNode;
                if (curNode == NULL)  // adding node to the end
                    newNode->next = NULL;
                else  // node added in between two nodes
                    newNode->next = curNode;
            }
        }
    }
    return 0;
}
