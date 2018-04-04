// CE1007/CZ1007 Data Structures
// Week 10 Lab Tutorial - Linked List

#include <stdio.h>
#include <stdlib.h>

typedef struct _listnode{
	int num;
	struct _listnode *next;
} ListNode;

int duplicateReverse(ListNode *head, ListNode **ptrNewHead);
void printList(ListNode *head);
ListNode * findNode(ListNode *head, int index);
int insertNode(ListNode **ptrHead, int index, int value);

int main()
{
	int i;
	ListNode *head = NULL;
	ListNode *dupRevHead = NULL;

	for (i = 1; i <10; i++)  //build a new linked list
		insertNode(&head, 0, i);
	printList(head);
	duplicateReverse(head, &dupRevHead);
	printf("After duplicateReverse(),");
	printList(dupRevHead);
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

int duplicateReverse(ListNode *head, ListNode **ptrNewHead){
	// write your code here
	ListNode *currentNode = head;
	while (currentNode != NULL){
        insertNode(ptrNewHead, 0, currentNode->num);
        currentNode = currentNode->next;
	}
    return 0;
}
