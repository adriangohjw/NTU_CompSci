// CE1007/CZ1007 Data Structures
// Week 10 Lab Tutorial - Linked List

#include <stdio.h>
#include <stdlib.h>

typedef struct _listnode{
	int num;
	struct _listnode *next;
} ListNode;

void printList(ListNode *head);
ListNode * findNode(ListNode *head, int index);
int insertNode(ListNode **ptrHead, int index, int value);
int concatenate(ListNode **ptrHead1, ListNode *ptrHead2);

int main()
{
    int i;
	ListNode *ptrHead1 = NULL, *ptrHead2 = NULL;

	for (i=5; i>=1; i--){
        insertNode(&ptrHead1, 0, (i*2)-1);
        insertNode(&ptrHead2, 0, (i*2));
	}

    printf("List1: ");
    printList(ptrHead1);
    printf("List2: ");
    printList(ptrHead2);
    printf("\n");

	concatenate(&ptrHead1, ptrHead2);
	printf("concatenate(current list, duplicate reverse list)\n");
	printList(ptrHead1);

	return 0;
}

void printList(ListNode *head){
	ListNode *cur = head;

	if (cur == NULL)
		return;

	printf("the current linked list is:\n");
	while (cur != NULL){
		printf("%d ", cur->num);
		cur = cur->next;
	}
	printf("\n");
}

ListNode * findNode(ListNode *head, int index){
	if (head == NULL || index < 0) return NULL;
	while (index > 0){
		head = head->next;
		if (head == NULL)
			return NULL;
		index--;
	}
	return head;
}

int insertNode(ListNode **ptrHead, int index, int value){
	ListNode *pre, *cur;
	// If empty list or inserting first node, need to update head pointer
	if (*ptrHead == NULL || index == 0){
		cur = *ptrHead;
		*ptrHead = malloc(sizeof(ListNode));
		(*ptrHead)->num = value;
		(*ptrHead)->next = cur;
		return 0;
	}
	// Find the nodes before and at the target position
	// Create a new node and reconnect the links
	if ((pre = findNode(*ptrHead, index - 1)) != NULL){
		cur = pre->next;
		pre->next = malloc(sizeof(ListNode));
		pre->next->num = value;
		pre->next->next = cur;
		return 0;
	}
	return -1;
}

int concatenate(ListNode **ptrHead1, ListNode *ptrHead2){
	// write your code here
	// **ptrHead1 is memory that points to address of first node
	//  *ptrHead1 is address of first node
	//  *ptrHead2 is address of first node
    ListNode *current = *ptrHead1;
    if (current == NULL){  // List 1 is null
        if (ptrHead2 == NULL)
            return -1;
        *ptrHead1 = ptrHead2;
    } else {
        while (current != NULL){
            if (current->next == NULL)
                break;
            current = current->next;
        }
        current->next = ptrHead2;
    }
    return 0;
}
