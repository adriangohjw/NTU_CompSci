//////////////////////////////////////////////////////////////////////////////////

/* CE1007/CZ1007 Data Structures
2017/18 S2
Submission Deadline: April 13th, 2018 (Friday) 11.59 pm.
Purpose: Implementing the required functions for Question 3 */

//////////////////////////////////////////////////////////////////////////////////

#include <stdio.h>
#include <stdlib.h>

//////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////
typedef struct _btnode
{
    int item;
    struct _btnode *left;
    struct _btnode *right;
} BTNode;   // You should not change the definition of BTNode

/////////////////////////////////////////////////////////////////////////////////

typedef struct _stackNode
{
    BTNode *btnode;
    struct _stackNode *next;
} StackNode;

typedef struct _stack
{
    StackNode *top;
} Stack;


///////////////////////// function prototypes ////////////////////////////////////
int countOneChildNodes(BTNode *node);
BTNode *createBTNode(int item);

// You may use the following functions or you may write your own
BTNode *createTree();
void push( Stack *stack, BTNode *node);
BTNode* pop(Stack *stack);

void printTree(BTNode *node);
void removeAll(BTNode **node);

///////////////////////////// main() /////////////////////////////////////////////

int main()
{
    char e;
    int c,s;
    BTNode *root;


    printf("1: Create a binary tree.\n");
    printf("2: Count the number of nodes that have exactly one child node.\n");
    printf("0: Quit;\n");

    c = 1;
    root = NULL;


    while(c != 0)
    {
        printf("Please input your choice(1/2/0): \n");
        if( scanf("%d",&c) > 0)
        {
            switch(c)
            {
            case 1:
                removeAll(&root);
                root = createTree();
                printf("The resulting binary tree is: ");
                printTree(root);
                printf("\n");
                break;
            case 2:
                s = countOneChildNodes(root);
                printf("The number of nodes that have exactly one child node is: %d.\n", s);
                removeAll(&root);
                break;
            case 0:
                removeAll(&root);
                break;
            default:
                printf("Choice unknown;\n");
                break;
            }
        }
        else
        {
            scanf("%c",&e);
        }

    }
    return 0;
}

//////////////////////////////////////////////////////////////////////////////////

int countOneChildNodes(BTNode *node)

{
    /* add your code here */
    if (node == NULL)
        return 0;
    else if (node->left == NULL && node->right != NULL)
        return 1;
    else if (node->left != NULL && node->right == NULL)
        return 1;
    else
        return countOneChildNodes(node->left) + countOneChildNodes(node->right);
}

///////////////////////////////////////////////////////////////////////////////////

BTNode *createBTNode(int item)
{
    BTNode *newNode = malloc(sizeof(BTNode));
    newNode->item = item;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

//////////////////////////////////////////////////////////////////////////////////


BTNode *createTree()
{
    Stack stack;
    BTNode *root, *temp;
    char s;
    int item;

    stack.top = NULL;
    root = NULL;
    printf("Input an integer that you want to add to the binary tree. Any Alpha value will be treated as NULL.\n");
    printf("Enter an integer value for the root: \n");
    if(scanf("%d",&item) > 0)
    {
        root = createBTNode(item);
        push(&stack,root);
    }
    else
    {
        scanf("%c",&s);
    }

    while((temp =pop(&stack)) != NULL)
    {

        printf("Enter an integer value for the Left child of %d: \n", temp->item);

        if(scanf("%d",&item)> 0)
        {
            temp->left = createBTNode(item);
        }
        else
        {
            scanf("%c",&s);
        }

        printf("Enter an integer value for the Right child of %d: \n", temp->item);
        if(scanf("%d",&item)>0)
        {
            temp->right = createBTNode(item);
        }
        else
        {
            scanf("%c",&s);
        }

        if(temp->right != NULL)
            push(&stack,temp->right);
        if(temp->left != NULL)
            push(&stack,temp->left);
    }
    return root;
}

void push( Stack *stack, BTNode *node)
{
    StackNode *temp;

    temp = malloc(sizeof(StackNode));
    if(temp == NULL)
        return;
    temp->btnode = node;
    if(stack->top == NULL)
    {
        stack->top = temp;
        temp->next = NULL;
    }
    else
    {
        temp->next = stack->top;
        stack->top = temp;
    }
}

BTNode* pop(Stack *stack)
{
    StackNode *temp, *top;
    BTNode *ptr;
    ptr = NULL;

    top = stack->top;
    if(top != NULL)
    {
        temp = top->next;
        ptr = top->btnode;

        stack->top = temp;
        free(top);
        top = NULL;
    }
    return ptr;
}

void printTree(BTNode *node)
{
    if(node == NULL) return;

    printTree(node->left);
    printf("%d ",node->item);
    printTree(node->right);
}

void removeAll(BTNode **node)
{
    if(*node != NULL)
    {
        removeAll(&((*node)->left));
        removeAll(&((*node)->right));
        free(*node);
        *node = NULL;
    }
}
