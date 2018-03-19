#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    int value;
    struct node *next;
} ListNode;

typedef struct _linkedlist{
    int size;
    ListNode *head;
} LinkedList;

void printList(ListNode *head);
int removeNode2(LinkedList *ll, int index);
ListNode * findNode(ListNode *head, int index);

int main()
{
    LinkedList ll;
    ll.size = 0;
    ll.head = NULL;

    int num;
    printf("Enter a list of numbers, terminated by the value -1:\n");
    scanf("%d", &num);

    ListNode *temp;
    while (num != -1){
        if ((ll.size) == 0){
            temp = malloc(sizeof(ListNode));
            if (temp == NULL)
                return -1;
            ll.head = temp;
        } else {
            temp = malloc(sizeof(ListNode));
            if (temp == NULL)
                return -1;
            (findNode(ll.head, (ll.size)-1))->next = temp;
        }
        temp->value = num;
        temp->next = NULL;
        (ll.size)++;

        scanf("%d", &num);
    }

    printf("Current list: ");
    printList(ll.head);

    int askRemove;
    printf("Node at which index to remove? (-1 to Exit): ");
    scanf("%d", &askRemove);
    while (askRemove != -1){
        switch(removeNode2(&ll, askRemove)){
        case 0:  // successfully removed
            printf("Successfully removed!\n");
            printList(ll.head);
            break;
        case -1:  // unsuccessful removal
            printf("Removal failed!\n");
            break;
        default:
            printf("Error!\n");
            break;
        }
        printf("Node at which index to remove? (-1 to Exit): ");
        scanf("%d", &askRemove);
    }

    return 0;
}

void printList(ListNode *head){
    ListNode *temp = head;
    while (temp != NULL){
        printf("%d ", temp->value);
        temp = temp->next;
    }
    printf("\n");
}

ListNode * findNode(ListNode *head, int index){
    if (index < 0 || head == NULL)
        return NULL;
    ListNode *temp = head;
    while (index > 0){
        if (temp->next == NULL)
            return NULL;
        temp = temp->next;
        index--;
    }
    return temp;
}

int removeNode2(LinkedList *ll, int index){
    // wrong index OR LinkedList is empty
    if ((ll->size) <= 0 || index >= (ll->size))
        return -1;
    else {
        if (index == 0) // node is the first
            ll->head = ll->head->next;
        else if (index == (ll->size)-1){  // node is last node
            ListNode *pre = findNode((ll->head), index-1);
            pre->next = NULL;
        } else {  // node in the middle (not first or last)
            ListNode *pre = findNode((ll->head), index-1);
            pre->next = pre->next->next;
        }
        (ll->size)--;
        return 0;
    }
}
