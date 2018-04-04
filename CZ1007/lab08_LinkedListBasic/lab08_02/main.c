#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    int value;
    struct node *next;
} ListNode;

void printList(ListNode *head);
int searchList(ListNode *head, int value);

int main()
{
    ListNode *head = NULL, *temp;

    int num;
    printf("Enter a list of numbers, terminated by the value -1:\n");
    scanf("%d", &num);

    while (num != -1){
        if (head == NULL){
            head = malloc(sizeof(ListNode));
            temp = head;
        } else {
            temp->next = malloc(sizeof(ListNode));
            temp = temp->next;
        }
        temp->value = num;
        temp->next = NULL;

        scanf("%d", &num);
    }

    printf("Current list: ");
    printList(head);

    int search;
    printf("Enter value to search for: ");
    scanf("%d", &search);

    while (search != -1){
        printf("Value %d found at index %d\n", search, searchList(head, search));
        printf("Enter value to search for: ");
        scanf("%d", &search);
    }

    // clear memory taken by linked list
    while (head != NULL) {
        ListNode *temp = head->next;
        free(head);
        head = temp;
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

int searchList(ListNode *head, int value){
    int index = 0;
    ListNode *temp = head;

    while (temp != NULL){
        if (temp->value == value)
            return index;
        else {
            temp = temp->next;
            index++;
        }
    }
    return -1;
}
