#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    int value;
    struct node *next;
} ListNode;

void printList(ListNode *head);
int removeNode(ListNode **ptrHead, int index);
ListNode * findNode(ListNode *head, int index);

int main()
{
    ListNode *head = NULL, *temp;

    int num;
    printf("Enter a list of numbers, terminated by the value -1:\n");
    scanf("%d", &num);

    while (num != -1){
        if (head == NULL){
            // if Linked List currently empty
            head = malloc(sizeof(ListNode));
            temp = head;
        } else {
            // if Linked List is not empty
            temp->next = malloc(sizeof(ListNode));
            temp = temp->next;
        }
        // temp is the last node
        temp->value = num;
        temp->next = NULL;

        scanf("%d", &num);
    }

    printf("Current list: ");
    printList(head);

    int askRemove;
    printf("Node at which index to remove? (-1 to Exit): ");
    scanf("%d", &askRemove);
    while (askRemove != -1){
        switch(removeNode(&head, askRemove)){
        case 0:  // successfully removed
            printf("Successfully removed!\n");
            break;
        case -1:  // unsuccessful removal
            printf("Removal failed!\n");
            break;
        default:
            printf("Error!\n");
            break;
        }
        printList(head);
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
    ListNode *temp = head;
    if (head == NULL || index < 0)
        return NULL;
    while (index > 0){
        temp = temp->next;
        if (temp == NULL)
            return NULL;
        index--;
    }
    return temp;
}

int removeNode(ListNode **ptrHead, int index){
    // **ptrHead is the address of the first node
    //  *ptrHead is the first node
    if (index < 0 || *ptrHead == NULL)  // error if negative index chosen // no node
        return -1;
    else if (index == 0)  // if first node chosen to be removed
        (*ptrHead) = (*ptrHead)->next;
    else {
        ListNode *pre = findNode(*ptrHead, index-1), *cur;
        if (pre == NULL || pre->next == NULL)
            return -1;  // current is the currentNode
        else {
            cur = pre->next->next;
            pre->next = cur;
        }
    }
    return 0;
}
