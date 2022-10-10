#include <stdio.h>
#include <stdlib.h>

struct _listNode{
    int item;
    struct _listNode* next;
};
typedef struct _listNode ListNode;

void printList(ListNode *head);
void deleteList(ListNode **ptrHead);

void reverseKNodes(ListNode** head, int K);

int main()
{
    ListNode *head = NULL, *temp;
	int i = 0;
	int K = 0;

	scanf("%d",&K);

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


	reverseKNodes(&head, K);
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

void reverseKNodes(ListNode** head, int K){
//Write your code here    
    ListNode *prev = NULL;
    ListNode *next_node;
    ListNode *cur = *head;
    ListNode *counter = *head;
    ListNode *toReturn = *head;
    ListNode *dummy = NULL;
    ListNode *dummyPtr = NULL;



    int total = 0;
    int loops = 0;

    while(counter !=NULL){
        total++;
        counter = counter->next;
    }
    
    while (total >= K && cur != NULL && K != 0){
        int count = 0;
        loops++;
        dummy = cur;
        while (cur != NULL && count < K){
            next_node = cur->next;
            cur->next = prev;
            prev = cur;
            cur = next_node;
            count++;
        }
        if(loops == 1){
            toReturn = prev;
        }
        total -= K;
        if (total >= K){
            dummyPtr = cur;
            for (int i = 0; i < (K-1); i++){
                dummyPtr = dummyPtr->next;
            }
            dummy->next = dummyPtr;
 
        }
        else{
            dummy->next = cur;
        }
    }
    *head = toReturn;
}