#include <stdio.h>
#include <stdlib.h>

struct _listNode{
    int item;
    struct _listNode* next;
};
typedef struct _listNode ListNode;

typedef struct _linkedList{
    ListNode *head;
    int size;
}LinkedList;

void printList(LinkedList ll);
void deleteList(LinkedList* llptr);

LinkedList rearrange (LinkedList ll);

int main()
{
    LinkedList ll;

    ll.head = NULL;
    ll.size = 0;
    ListNode* temp;

	int i = 0;

	while (scanf("%d", &i)){
		if (ll.head == NULL){
			ll.head = (ListNode*) malloc(sizeof(ListNode));
			temp = ll.head;
		}
		else{
			temp->next = (ListNode*) malloc(sizeof(ListNode));
			temp = temp->next;
		}
		temp->item = i;
		ll.size++;
	}
	temp->next = NULL;

	ll=rearrange(ll);

	printList(ll);
    deleteList(&ll);
	return 0;
}

void printList(LinkedList ll){
    ListNode* temp = ll.head;

    while(temp !=NULL){
        printf("%d ",temp->item);
        temp = temp->next;
    }
    printf("\n");
}
void deleteList(LinkedList* llptr){
    ListNode *cur = llptr->head;
    ListNode *temp;
    while (cur!= NULL) {
		temp=cur->next;
		free(cur);
		cur=temp;
	}
	llptr->head=NULL;
	llptr->size =0;
}

LinkedList rearrange (LinkedList ll){
// Write your code here

	ListNode *cur = ll.head;
	ListNode *newNode;
	ListNode *list1 = NULL;
	ListNode *list2 = NULL;
	ListNode *assembledList1 = NULL;
	ListNode *list1Pre = NULL;
	ListNode *list2Pre = NULL;
	ListNode *assembledList1Pre = NULL;

	if (ll.size > 1){
		for(int i = 0; i < (ll.size / 2); i++){
			if (list1 == NULL){
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list1;
				list1 = newNode;
			}
			else{
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list1Pre->next;
				list1Pre->next = newNode;
			}
			list1Pre = newNode;
			cur = cur->next;
		}

		for(int i = 0; i < ((ll.size / 2) + (ll.size % 2)); i++){
			if (list2 == NULL){
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list2;
				list2 = newNode;
			}
			else{
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list2Pre->next;
				list2Pre->next = newNode;
			}
			list2Pre = newNode;
			cur = cur->next;
		}
	
		for (int i = 0; i < ll.size+1; i++){
			if(i % 2 == 0){
				if (list2 != NULL){
					if (assembledList1 == NULL){
						newNode = malloc(sizeof(ListNode));
						newNode->item = list2->item;
						newNode->next = assembledList1;
						assembledList1 = newNode;
					}
					else{
						newNode = malloc(sizeof(ListNode));
						newNode->item = list2->item;
						newNode->next = assembledList1Pre->next;
						assembledList1Pre->next = newNode;
					}
					assembledList1Pre = newNode;
					list2 = list2->next;
				}
				
			}
			else if (i % 2 == 1){
				if(list1 != NULL){
					if (assembledList1 == NULL){
						newNode = malloc(sizeof(ListNode));
						newNode->item = list1->item;
						newNode->next = assembledList1;
						assembledList1 = newNode;
					}
					else{
						newNode = malloc(sizeof(ListNode));
						newNode->item = list1->item;
						newNode->next = assembledList1Pre->next;
						assembledList1Pre->next = newNode;
					}
					assembledList1Pre = newNode;
					list1 = list1->next;
				}
			}
		}
		
		list1 = NULL;
		list2 = NULL;
		list1Pre = NULL;
		list2Pre = NULL;
		cur = assembledList1;

		for(int i = 0; i < (ll.size / 2); i++){
			if (list1 == NULL){
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list1;
				list1 = newNode;
			}
			else{
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list1Pre->next;
				list1Pre->next = newNode;
			}
			list1Pre = newNode;
			cur = cur->next;
		}

		for(int i = 0; i < ((ll.size / 2) + (ll.size % 2)); i++){
			if (list2 == NULL){
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list2;
				list2 = newNode;
			}
			else{
				newNode = malloc(sizeof(ListNode));
				newNode->item = cur->item;
				newNode->next = list2Pre->next;
				list2Pre->next = newNode;
			}
			list2Pre = newNode;
			cur = cur->next;
		}
		assembledList1 = NULL;
		assembledList1Pre = NULL;

		for (int i = 0; i < ll.size+1; i++){
			if(i % 2 == 1){
				if (list2 != NULL){
					if (assembledList1 == NULL){
						newNode = malloc(sizeof(ListNode));
						newNode->item = list2->item;
						newNode->next = assembledList1;
						assembledList1 = newNode;
					}
					else{
						newNode = malloc(sizeof(ListNode));
						newNode->item = list2->item;
						newNode->next = assembledList1Pre->next;
						assembledList1Pre->next = newNode;
					}
					assembledList1Pre = newNode;
					list2 = list2->next;
				}
				
			}
			else if (i % 2 == 0){
				if(list1 != NULL){
					if (assembledList1 == NULL){
						newNode = malloc(sizeof(ListNode));
						newNode->item = list1->item;
						newNode->next = assembledList1;
						assembledList1 = newNode;
					}
					else{
						newNode = malloc(sizeof(ListNode));
						newNode->item = list1->item;
						newNode->next = assembledList1Pre->next;
						assembledList1Pre->next = newNode;
					}
					assembledList1Pre = newNode;
					list1 = list1->next;
				}
			}
		}
		



		ll.head = assembledList1;
	}
	
	return ll;
}
