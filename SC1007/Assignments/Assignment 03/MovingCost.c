#include <stdio.h>
#include <stdlib.h>

typedef struct _btnode{
    int nodeV;
    struct _btnode *left;
    struct _btnode *right;
} BTNode;

typedef struct _queuenode{
    BTNode* node;
    struct _queuenode *next;
}QueueNode;

typedef struct _queue{
   int size;
   QueueNode *head;
   QueueNode *tail;
} Queue;

void printBTNode(BTNode *root, int space,int left);
//Prototypes of Interface functions for Queue structure
void enqueue(Queue *qPtr, BTNode * node);
int dequeue(Queue *qPtr);
BTNode* getFront(Queue q);
int isEmptyQueue(Queue q);

int twoNodesCost(BTNode* node, int nodeV1,int nodeV2);

int main()
{
    BTNode* root = (BTNode*) malloc(sizeof(BTNode));

    Queue q;
    q.head = NULL;
    q.tail = NULL;
    q.size = 0;

    BTNode* node;
    enqueue(&q,root);

    int nodeV;
    char opL, opR;

    while(!isEmptyQueue(q)){
            scanf("%d %c %c",&nodeV,&opL,&opR);
            node = getFront(q);dequeue(&q);
            node->nodeV = nodeV;

            if(opL != '@'){
                node->left = (BTNode*) malloc(sizeof(BTNode));
                enqueue(&q,node->left);
            }
            else node->left =NULL;
            if(opR != '@'){
                node->right = (BTNode*) malloc(sizeof(BTNode));
                enqueue(&q,node->right);
            }
            else
                node->right = NULL;
    }

    int v1,v2;
    scanf("%d %d",&v1,&v2);
    int cost = twoNodesCost(root,v1,v2);

    printBTNode(root,0,0);

    printf("Distance is %d\n",cost);
    return 0;
}

void enqueue(Queue *qPtr, BTNode *node){
    QueueNode *newNode;
    newNode = malloc(sizeof(QueueNode));
    newNode->node = node;
    newNode->next = NULL;

    if(isEmptyQueue(*qPtr))
        qPtr->head=newNode;
    else
        qPtr->tail->next = newNode;

    qPtr->tail = newNode;
    qPtr->size++;
}

int dequeue(Queue *qPtr){
    if(qPtr==NULL || qPtr->head==NULL){ //Queue is empty or NULL pointer
        return 0;
    }
    else{
       QueueNode *temp = qPtr->head;
       qPtr->head = qPtr->head->next;
       if(qPtr->head == NULL) //Queue is emptied
           qPtr->tail = NULL;

       free(temp);
       qPtr->size--;
       return 1;
    }
}

BTNode* getFront(Queue q){
    return q.head->node;
}

int isEmptyQueue(Queue q){
    if(q.size==0) return 1;
    else return 0;
}
void printBTNode(BTNode *root,int space,int left){
      if (root != NULL)
      {

          int i;
          for (i = 0; i < space-1; i++)
                 printf("|\t");


          if(i<space){
            if(left==1)
              printf("|---");
            else
              printf("|___");
          }

          printf("%d\n", root->nodeV);

          space++;
          printBTNode(root->left, space,1);
          printBTNode(root->right, space,0);
      }
}

int ifLCAExist(BTNode* node, int nodeV1, int nodeV2);
int ifLCAExist(BTNode* node, int nodeV1, int nodeV2){
    int total = 0;
    

    if(node == NULL){
        return 0;
    }
    if(node->nodeV == nodeV1 || node->nodeV == nodeV2){
        total += 1;
    }

    total += ifLCAExist(node->left, nodeV1, nodeV2);
    total += ifLCAExist(node->right, nodeV1, nodeV2);

    return total;
}

BTNode* lowestCommonAncestor(BTNode* node, int nodeV1, int nodeV2);
BTNode* lowestCommonAncestor(BTNode* node, int nodeV1, int nodeV2){
    BTNode* leftNode = (BTNode*) malloc(sizeof(BTNode));
    BTNode* rightNode = (BTNode*) malloc(sizeof(BTNode));

    if(node == NULL){
        return NULL;
    }

    if(node->nodeV == nodeV1 || node->nodeV == nodeV2){
        return node;
    }

    if(node->left == NULL && node->right == NULL){
        return NULL;
    }

    leftNode = lowestCommonAncestor(node->left, nodeV1, nodeV2);
    rightNode = lowestCommonAncestor(node->right, nodeV1, nodeV2);

    if(leftNode != NULL && rightNode != NULL){
        return node;
    }

    if (leftNode == NULL && rightNode == NULL){
        return NULL;
    }

    if(leftNode != NULL && rightNode == NULL){
        return leftNode;
    }

    if(leftNode == NULL && rightNode != NULL){
        return rightNode;
    }


}

int calcMoveCost(BTNode* node, int value);
int calcMoveCost(BTNode* node, int value){
    int leftNode, rightNode = 0;

    if(node == NULL){
        return 0;
    }

    if(node->nodeV == value){
        return node->nodeV;
    }

    if(node->left == NULL && node->right == NULL){
        return 0;
    }

    leftNode = calcMoveCost(node->left, value);
    rightNode = calcMoveCost(node->right, value);

    if(leftNode != 0 && rightNode == 0){
        return (leftNode) + (node->nodeV);
    }
    if(leftNode == 0 && rightNode != 0){
        return (rightNode) + (node->nodeV);
    }
    
}

int twoNodesCost(BTNode* node, int nodeV1,int nodeV2)
{

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

// Write your code here
    if(ifLCAExist(node, nodeV1, nodeV2) == 1){
        if(nodeV1 == nodeV2){
            return nodeV1;
        }
    }
    
    if(ifLCAExist(node, nodeV1, nodeV2) == 2){
        return calcMoveCost(lowestCommonAncestor(node, nodeV1, nodeV2), nodeV1) + calcMoveCost(lowestCommonAncestor(node, nodeV1, nodeV2), nodeV2) - lowestCommonAncestor(node, nodeV1, nodeV2)->nodeV; 
    }
    return 0;
}