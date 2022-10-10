#include <stdio.h>
#include <stdlib.h>

struct _listNode{
    int item;
    struct _listNode* next;
};
typedef struct _listNode ListNode;

void printList(ListNode *head);
void deleteList(ListNode **ptrHead);

void triPartition(ListNode** head, int pivot);

int main()
{
    ListNode *head = NULL, *temp;
	int i = 0;
	int pivot = 0;

	scanf("%d",&pivot);

	while (scanf("%d", &i)){
		if (head == NULL){
			head = (ListNode*) malloc(sizeof(ListNode));
			temp = head;
		}
		else{
			temp->next = (ListNode*) malloc(sizeof(ListNode));
			temp = temp->next;
		}
		temp->item = i;
	}
	temp->next = NULL;


	triPartition(&head, pivot);
	printList(head);
	deleteList(&head);

	return 0;
}

void printList(ListNode *head){
    while(head !=NULL){
        printf("%d ",head->item);
        head = head->next;
    }
    printf("\n");
}

void deleteList(ListNode **ptrHead){
    ListNode *cur = *ptrHead;
    ListNode *temp;
    while (cur!= NULL) {
		temp=cur->next;
		free(cur);
		cur=temp;
	}
	*ptrHead=NULL;
}

void triPartition(ListNode** head, int pivot){

// Write your code here
	ListNode *cur = *head;
	ListNode *newNode;
	ListNode *smallerList = NULL;
	ListNode *biggerList = NULL;
	ListNode *equalList = NULL;
	ListNode *smallerPre = NULL;
	ListNode *biggerPre = NULL;
	ListNode *equalPre = NULL;

	int count = 0;
	while (cur != NULL){
		if	(cur->item < pivot){
			if (smallerList == NULL){
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = smallerList;
				smallerList = newNode;
			}
			else{
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = smallerPre->next;
				smallerPre->next = newNode;
			}
			smallerPre = newNode;
		}
		else if (cur->item > pivot){
			if (biggerList == NULL){
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = biggerList;
				biggerList = newNode;
			}
			else{
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = biggerPre->next;
				biggerPre->next = newNode;
			}
			biggerPre = newNode;
		}
		else{
			if (equalList == NULL){
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = equalList;
				equalList = newNode;
			}
			else{
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = equalPre->next;
				equalPre->next = newNode;
			}
			equalPre = newNode;
		}
		cur = cur->next;
		count++;
	}
	if(count != 0){
		if (smallerList != NULL && equalList != NULL && biggerList != NULL){
			smallerPre->next = equalList;
			equalPre->next = biggerList;
			(*head) = smallerList;
		}
		else if(smallerList != NULL && equalList != NULL && biggerList == NULL){
			smallerPre->next = equalList;
			(*head) = smallerList;
		}
		else if(smallerList != NULL && equalList == NULL && biggerList != NULL){
			smallerPre->next = biggerList;
			(*head) = smallerList;
		}
		else if(smallerList != NULL && equalList == NULL && biggerList == NULL){
			(*head) = smallerList;
		}
		else if(smallerList == NULL && equalList != NULL && biggerList != NULL){
			equalPre->next = biggerList;
			(*head) = equalList;
		}
		else if(smallerList == NULL && equalList != NULL && biggerList == NULL){
			(*head) = equalList;
		}
		else if(smallerList == NULL && equalList == NULL && biggerList != NULL){
			(*head) = biggerList;
		}
	}

}