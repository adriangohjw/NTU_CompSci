#include <stdio.h>
#include <stdlib.h>

struct _listNode{
    float item;
    struct _listNode* next;
};
typedef struct _listNode ListNode;

void printList(ListNode *head);
void deleteList(ListNode **ptrHead);

ListNode *reverseSegment(ListNode* head, int start, int end);

int main()
{
    ListNode *head = NULL, *temp;
	float f = 0.0;
	int S, E;

	scanf("%d %d",&S, &E);

	while (scanf("%f", &f)){
		if (head == NULL){
			head = (ListNode*) malloc(sizeof(ListNode));
			temp = head;
		}
		else{
			temp->next = (ListNode*) malloc(sizeof(ListNode));
			temp = temp->next;
		}
		temp->item = f;
	}
	temp->next = NULL;

	head = reverseSegment(head,S,E);
	printList(head);
	deleteList(&head);
	return 0;

}

void printList(ListNode *head){
    while(head !=NULL){
        printf("%.2f ",head->item);
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

ListNode *reverseSegment(ListNode* head, int start, int end)
{
// Write your code here
	ListNode *cur = head;
	ListNode *next_node;
	ListNode *prev = NULL;
	ListNode *dummy = NULL;
	ListNode *counter = head;
	ListNode *startPtr = head;
	ListNode *endPtr = head;
	ListNode *last;
	ListNode *befStart = head;

	int total = 0;

    while(counter !=NULL){
        total++;
        counter = counter->next;
    }

	if((start < total) && (end < total) && (start >= 0) && (end >= 0) && (start != end) && (start < end) && (total > 0)){
		for(int i = 0; i < end; i++){
			endPtr = endPtr->next;
			last = endPtr->next;
		}
		for(int i = 0; i < start; i++){
			befStart = startPtr;
			startPtr = startPtr->next;
		}
		dummy = startPtr;
		for(int i = 0; i < (end - start)+1; i++){
			next_node = startPtr->next;
            startPtr->next = prev;
            prev = startPtr;
            startPtr = next_node;
		}
		dummy->next = last;
		if (start != 0){
			befStart->next = endPtr;
		}
		else{
			return endPtr;
		}
	}
	return head;
}