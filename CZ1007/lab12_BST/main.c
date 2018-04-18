//////////////////////////////////////////////////////////////////////

// CE1007/CZ1007 Data Structures
// Week 13 Lab and Tutorial - Binary Search Tree

#include <stdio.h>
#include <stdlib.h>

///////////////////////////////////////////////////////////////////////

typedef struct _btnode{
int item;
struct _btnode *left;
struct _btnode *right;
} BTNode;

///////////////////////////////////////////////////////////////////////

void insertBSTNode(BTNode **node, int value);
void printBSTInOrder(BTNode *node);
int isBST(BTNode *node, int min, int max);
BTNode *removeBSTNode(BTNode *node, int value);
BTNode *findMin(BTNode *p);

///////////////////////////////////////////////////////////////////////

int main(){
	int i=0;

	BTNode *root=NULL;

	//question 1
	do{
		printf("input a value you want to insert(-1 to quit):");

		scanf("%d",&i);
		if (i!=-1)
			insertBSTNode(&root,i);
	}while(i!=-1);

	//question 2
	printf("\n");
	printBSTInOrder(root);

	//question 3
	if ( isBST(root,-1000000, 1000000)==1)
		printf("It is a BST!\n");
	else
		printf("It is not a BST!\n");

	//question 4
	do{
		printf("\ninput a value you want to remove(-1 to quit):");
		scanf("%d",&i);
		if (i!=-1)
		{
			root=removeBSTNode(root,i);
			printBSTInOrder(root);
		}
	}while(i!=-1);


	return 0;
}

//////////////////////////////////////////////////////////////////////

void insertBSTNode(BTNode **node, int value)
{
	// write your code here
	BTNode *newNode = malloc(sizeof(BTNode));
	if (newNode == NULL) return ;

	// empty BTS
	if (*node == NULL){
        newNode->left = NULL;
        newNode->right = NULL;
        newNode->item = value;
        *node = newNode;
        return ;
	}

	// BTS not empty
    if ((*node)->item == value) return ;  // existing value in BTS
    if ((*node)->item > value)
        insertBSTNode(&((*node)->left), value);
    else
        insertBSTNode(&((*node)->right), value);
}

//////////////////////////////////////////////////////////////////////

void printBSTInOrder(BTNode *node)
{
	// write your code here
	if (node == NULL) return ;
	printBSTInOrder(node->left);
	printf("%d ", node->item);
	printBSTInOrder(node->right);
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int isBST(BTNode *node, int min, int max) // the item stored in node has to be smaller than max and larger than min
{
	// write your code here
	int minimum(int a, int b){
        return a < b ? a : b;
	}

	// node empty
	if (node == NULL)
        return 1;

	BTNode *nodeL = node->left, *nodeR = node->right;
	if (nodeL == NULL && nodeR == NULL) // node is leaf
        return 1;
	if (nodeL == NULL)  // node only has right
        return (nodeR->item <= node->item) ? 0 : isBST(nodeL, min, node->item);
	if (nodeR == NULL)  // node only has left
        return (nodeL->item >= node->item) ? 0 : isBST(nodeR, node->item, max);
	if ((nodeL->item >= node->item) || (nodeR->item <= node->item))
        return 0;
    return minimum(isBST(nodeL, min, node->item), isBST(nodeR, node->item, max));
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

BTNode *removeBSTNode(BTNode *node, int value)
{
	// write your code here
	BTNode *findMin(BTNode *p){
        return (p == NULL) ? NULL : findMin(p->left);
    }

	// DEFAULT RETURN NODE
	if (node == NULL) return NULL;

    if (value < node->item)
        node->left = removeBSTNode(node->left, value);

    else if (node->item < value)
        node->right = removeBSTNode(node->right, value);

    else {  // same value
        // node is leaf
        if (node->left == NULL && node->right == NULL) return NULL;

        // node has 2 children + successor method used
        else if (node->left != NULL && node->right != NULL){
            BTNode *newNode = findMin(node->right);
            node->item = newNode->item;
            node->right = removeBSTNode(node->right, newNode->item);
        }

        // node only has 1 child
        else {
            BTNode *newNode = (node->left == NULL) ? node->right : node->left;
            return newNode;
        }
    }
    return node;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
