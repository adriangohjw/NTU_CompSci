#include <stdio.h>
#include <stdlib.h>

#define SIZE 1000 //The size of the infix

enum ExpType {OPT,OPERAND};

typedef struct _stackNode{
    char item;
    struct _stackNode *next;
}StackNode;

typedef struct _stack{
   int size;
   StackNode *head;
}Stack;

void push(Stack *sPtr, char item);
int pop(Stack *sPtr);
char peek(Stack s);
int isEmptyStack(Stack s);

typedef struct _listnode
{
    int  item;
    enum ExpType type;
	struct _listnode *next;
} ListNode;

typedef struct _linkedlist{
   int size;
   ListNode *head;
} LinkedList;

void insertNode(LinkedList *llPtr, int item,enum ExpType type);
int deleteNode(LinkedList *llPtr);
void removeAllNodes(LinkedList *llPtr);
int isEmptyLinkedList (LinkedList ll);


void in2PreLL(char* infix, LinkedList *inExpLL);

void printExpLL(LinkedList inExp);

int main()
{
    char infix[SIZE];

    //printf("Enter an infix expression:\n");
    scanf("%[^\n]%*c",infix);

    LinkedList inExpLL;
    inExpLL.head = NULL;
    inExpLL.size = 0;

    in2PreLL(infix, &inExpLL);

    printExpLL(inExpLL);

    removeAllNodes(&inExpLL);
    return 0;
}

void printExpLL(LinkedList inExpLL)
{
    ListNode* temp = NULL;
    temp = inExpLL.head;
    while(temp!= NULL){
        if(temp->type == OPERAND)
            printf(" %d ",temp->item);
        else
            printf(" %c ",(char)(temp->item));
        temp = temp->next;
    }
    printf("\n");
}

void insertNode(LinkedList *LLPtr, int item, enum ExpType type) {
    ListNode *newNode;
    newNode = malloc(sizeof(ListNode));
    if(newNode==NULL) exit(0);

    newNode->item = item;
    newNode->type = type;
    newNode->next = LLPtr->head;
    LLPtr->head=newNode;
    LLPtr->size++;
}

int deleteNode(LinkedList *LLPtr) {
    if(LLPtr==NULL || LLPtr->size==0){
        return 0;
    }
    else{
       ListNode *temp = LLPtr->head;
       LLPtr->head = LLPtr->head->next;

       free(temp);
       LLPtr->size--;
       return 1;
    }
}

int isEmptyLinkedList (LinkedList ll) {
    if(ll.size==0) return 1;
    else return 0;
}

void removeAllNodes(LinkedList *LLPtr)
{
	while(deleteNode(LLPtr));
}

void push(Stack *sPtr, char item){
    StackNode *newNode;
    newNode = malloc(sizeof(StackNode));
    newNode->item = item;
    newNode->next = sPtr->head;
    sPtr->head = newNode;
    sPtr->size++;
}

int pop(Stack *sPtr){
    if(sPtr == NULL || sPtr->head == NULL){
        return 0;
    }
    else{
       StackNode *temp = sPtr->head;
       sPtr->head = sPtr->head->next;
       free(temp);
       sPtr->size--;
       return 1;
    }
}

char peek(Stack s){
    return s.head->item;
}

int isEmptyStack(Stack s){
     if(s.size == 0) return 1;
     else return 0;
}


void in2PreLL(char* infix, LinkedList *inExpLL)
{
  //Write your code here
    int num;
    int total = 0;
    int setNum = 0;
    int sizeInfix = 0;
    char reverseInfix;

    Stack tmpStack;
    tmpStack.size = 0;

    while (infix[sizeInfix] != '\0'){
        sizeInfix += 1;
    }
    int i;
    int j = sizeInfix-1;
    for (i = 0; i < sizeInfix/2; i++){
        reverseInfix = infix[i];
        infix[i] = infix[j];
        infix[j] = reverseInfix;
        j--;
    }

    for (i = 0; infix[i] != '\0'; i++){
        if (infix[i] == 40){
            infix[i] = 41;
        }
        else if (infix[i] == 41){
            infix[i] = 40;
        }
    }

    for (i = 0; infix[i] != '\0'; i++){
        if(infix[i] != 37 && infix[i] != 40 && infix[i] != 41 && infix[i] != 42 && infix[i] != 43 && infix[i] != 45 && infix[i] != 47){
            setNum += 1;
            num = infix[i] - '0';
            if (setNum == 1){
                total += num;
            }
            else{
                for (int i = 1; i < setNum; i++){
                    num = num * (10);
                }
                total += num;
                }
        }
        else{
            if (setNum != 0){
                insertNode(inExpLL, total, OPERAND);
            }
            setNum = 0;
            total = 0;
            if(infix[i] == 41){
                while( (isEmptyStack(tmpStack) != 1) && peek(tmpStack) != 40){
                    insertNode(inExpLL, peek(tmpStack), OPT);
                    pop(&tmpStack);
                }
                if((isEmptyStack(tmpStack) != 1)){
                    pop(&tmpStack);
                }
            }
            else if(infix[i] == 40){
                push(&tmpStack, infix[i]);
            }
            else{
                //while((isEmptyStack(tmpStack) != 1) && (peek(tmpStack) != 40) && ( ((infix[i] == 43 || infix[i] == 45) && (peek(tmpStack) == 42 || peek(tmpStack) == 47)) || ((infix[i] == 43 || infix[i] == 45) && (peek(tmpStack) == 43 || peek(tmpStack) == 45)) || ((infix[i] == 42 || infix[i] == 47) && (peek(tmpStack) == 42 || peek(tmpStack) == 47))) ){
                while((isEmptyStack(tmpStack) != 1) && (peek(tmpStack) != 40) && ( ((infix[i] == 43 || infix[i] == 45) && (peek(tmpStack) == 42 || peek(tmpStack) == 47))) ){
                    insertNode(inExpLL, peek(tmpStack), OPT);
                    pop(&tmpStack);
                }
                push(&tmpStack, infix[i]);
            }
        }
    }
    if (setNum != 0){
        insertNode(inExpLL, total, OPERAND);
    }
    while ((isEmptyStack(tmpStack) != 1)){
        if (peek(tmpStack) == 40){
            insertNode(inExpLL, 41, OPT);
        }
        else if (infix[i] == 41){
            insertNode(inExpLL, 40, OPT);
        }
        else{
            insertNode(inExpLL, peek(tmpStack), OPT);
        }
        
        pop(&tmpStack);
    }
    
}

