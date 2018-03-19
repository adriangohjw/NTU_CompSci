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
int combineAlternating(ListNode **ptrHead, ListNode *head1, ListNode *head2);

int main()
{
	int i;
	ListNode *list1Head = NULL, *list2Head = NULL;
	ListNode *combAltHead = NULL;

	for (i = 3; i > 0; i--)				//build linked list 1
		insertNode(&list1Head, 0, i);
	for (i = 13; i > 10; i--)			//build linked list 2
		insertNode(&list2Head, 0, i);
	printf("List 1:");
	printList(list1Head);
	printf("List 2: ");
	printList(list2Head);
	combineAlternating(&combAltHead, list1Head, list2Head);
	printf("After combineAlternating(): ");
	printList(combAltHead);

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

int combineAlternating(ListNode **ptrHead, ListNode *head1, ListNode *head2){
	// write your code here
	int size_ptrHead = 0;
	ListNode *current1 = head1, *current2 = head2;
    while (current1 != NULL && current2 != NULL){
        insertNode(ptrHead, size_ptrHead++, current1->num);
        insertNode(ptrHead, size_ptrHead++, current2->num);

        if (current1->next == NULL || current2->next == NULL){
            if (current1->next == NULL && current2->next == NULL)
                return 0;
            if (current1->next == NULL){
                current2 = current2->next;
                while (current2 != NULL){
                    insertNode(ptrHead, size_ptrHead++, current2->num);
                    current2 = current2->next;
                }
            } else {  // current2->next == NULL
                current1 = current1->next;
                while (current1 != NULL){
                    insertNode(ptrHead, size_ptrHead++, current1->num);
                    current1 = current1->next;
                }
            }
            return 0;
        }

        current1 = current1->next;
        current2 = current2->next;
    }
    return 0;
}
