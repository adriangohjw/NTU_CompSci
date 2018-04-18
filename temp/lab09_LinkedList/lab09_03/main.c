// CE1007/CZ1007 Data Structures
// Week 10 Lab Tutorial - Linked List

#include <stdio.h>
#include <stdlib.h>

typedef struct _listnode{
	int num;
	struct _listnode *next;
} ListNode;

int split(ListNode *head, ListNode **ptrEvenList, ListNode **ptrOddList);
void printList(ListNode *head);
ListNode * findNode(ListNode *head, int index);
int insertNode(ListNode **ptrHead, int index, int value);

int main()
{
	int i;
	ListNode *head = NULL;
	ListNode *oddHead = NULL;
	ListNode *evenHead = NULL;

	for (i = 1; i <10; i++)  //build a new linked list
		insertNode(&head, 0, i);
	printf("insert 1-9 to the linked list,");
	printList(head);
	printf("split the current list, results:\n");
	split(head, &evenHead, &oddHead);
	printf("the even list");
	printList(evenHead);
	printf("the odd list");
	printList(oddHead);
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

int split(ListNode *head, ListNode **ptrEvenList, ListNode **ptrOddList)
{
	// write your code here
	int sizeEven = 0, sizeOdd = 0;
	ListNode *currentNode = head;

	while (currentNode != NULL){  // loop if not last node
        if ((currentNode->num) % 2 == 0){  // if node's number is even
            if (sizeEven == 0)
                insertNode(ptrEvenList, 0, currentNode->num);
            else
                insertNode(ptrEvenList, sizeEven, currentNode->num);
            sizeEven++;
        } else {  // if node's number is odd
            if (sizeOdd == 0)
                insertNode(ptrOddList, 0, currentNode->num);
            else
                insertNode(ptrOddList, sizeOdd, currentNode->num);
            sizeOdd++;
        }
        currentNode = currentNode->next;
	}
    return 1;
}
