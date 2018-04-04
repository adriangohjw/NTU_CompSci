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
int moveMaxToFront(ListNode **ptrHead);

int main()
{
	int i;
	ListNode *head = NULL;

	for (i=10; i>=0; i--) // build a new linked list
		insertNode(&head, 0, i);
	printList(head);
	moveMaxToFront(&head);
	printf("after moveMaxToFront()");
	printList(head);
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

int moveMaxToFront(ListNode **ptrHead){
	// write your code here
	int index = 0, indexMax = 0;
	ListNode *currentNode = *ptrHead;
	ListNode *pre = NULL;

	if (currentNode == NULL)  // if empty list of node
        return -1;
    int maxNum = currentNode->num;

	while (currentNode->next != NULL){
        if (currentNode->next->num > maxNum){
            pre = currentNode;
            indexMax = index + 1;
            maxNum = currentNode->next->num;
        }
        if (currentNode->next->next == NULL)
            break;
        currentNode = currentNode->next;
        index++;
	}

	// reassignment the bridge the gap
	if (indexMax == 0)  // if first node is largest number
        return 0;
    else if (indexMax == index) // if last node is largest number
        pre->next = NULL;
	else  // if node is in the middle
        pre->next = pre->next->next;

	insertNode(ptrHead, 0, maxNum);  // assignment to the front

	return indexMax;
}
