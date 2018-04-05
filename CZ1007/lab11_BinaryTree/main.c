// CX1007 DataStructures
// Week 12 Lab Tutorial - Binary Tree

#include <stdio.h>
#include <stdlib.h>

////////////////////////////////////////////////////////////////////
////////////

typedef struct _btnode{
	int item;
	struct _btnode *left;
	struct _btnode *right;

} BTNode;

////////////////////////////////////////////////////////////////////
////////////

void mirrorTree(BTNode *node);

void printSmallerValues(BTNode *node, int m);
int smallestValue(BTNode *node);
int hasGreatGrandchild(BTNode *node);

void printTree_InOrder(BTNode *node);

////////////////////////////////////////////////////////////////////

int main(int argc, const char * argv[]){

	int i;
	BTNode *root, *root2;
	BTNode btn[15];

	// Create the tree in Q1
	// Using manual dynamic allocation of memory for BTNodes

	root = malloc(sizeof(BTNode));
	root->item = 4;

	root->left = malloc(sizeof(BTNode));
	root->left->item = 5;

	root->right = malloc(sizeof(BTNode));
	root->right->item = 2;

	root->left->left = NULL;

	root->left->right = malloc(sizeof(BTNode));
	root->left->right->item = 6;

	root->left->right->left = NULL;
	root->left->right->right = NULL;

	root->right->left = malloc(sizeof(BTNode));
	root->right->left->item = 3;

	root->right->right = malloc(sizeof(BTNode));
	root->right->right->item = 1;

	root->right->left->left = NULL;

	root->right->left->right = NULL;

	root->right->right->left = NULL;

	root->right->right->right = NULL;

	printTree_InOrder(root);
	printf("\n");
	mirrorTree(root);
	printTree_InOrder(root);
	printf("\n\n");

	//question 2
	printf("Input m for question 2: ");
	scanf("%d", &i);
	printf("The values smaller than %d are: ", i);
	printSmallerValues(root, i);
	printf("\n\n");

	//question 3
	printf("The smallest value in the tree is %d", smallestValue(root));
	printf("\n\n");

	//question 4
	// Create a tree for Q4: Tall enough so some nodes have great-grandchildren
	// Use array of BTNodes, create tree by linking nodes together
	for (i = 0; i <= 7; i++){
		btn[i].item = i;
		btn[i].left = &(btn[i * 2 + 1]);
		btn[i].right = &(btn[i * 2 + 2]);
	}

	for (i = 7; i <= 14; i++){
		btn[i].item = i;
		btn[i].left = NULL;
		btn[i].right = NULL;
	}
	root2 = &btn[0];

	printf("The tree for question 4 visited by in-order is \n");
	printTree_InOrder(root2);
	printf("\nThe values stored in all nodes of the tree that have at least one great-grandchild are: \n");
    hasGreatGrandchild(root2);

	return 0;
}

void mirrorTree(BTNode *node){

	// write your code here
	if (node == NULL) return ;  // node has no child
	if ((node->left != NULL) && (node->right != NULL)){  // node has 2 children
        mirrorTree(node->right);
        BTNode *node_temp = node->left;
        node->left = node->right;
        node->right = node_temp;
        mirrorTree(node->right);
	} else if (node->left == NULL && node->right != NULL){  // node only has right child
        node->left = node->right;
        node->right = NULL;
        mirrorTree(node->left);
	} else if (node->left != NULL && node->right == NULL){  // node only has right child
	    node->right = node->left;
        node->left = NULL;
        mirrorTree(node->right);
	}
}

int hasGreatGrandchild(BTNode *node){

	// write your code here
	// cnt is hierarchy: 0 = primary node, 1 = child, 2 = grandchild, 3 = great grandchild */
	int hasGGC(BTNode *node, int cnt){
	    if (cnt == 3)  // return 3 if there is great grandchild
            return 1;
        if (node->left == NULL && node->right == NULL)
            return 0;
        else
            return hasGGC(node->left, cnt+1) + hasGGC(node->right, cnt+1);
	}

	if (node == NULL) return ;
    hasGreatGrandchild(node->left);
    if (hasGGC(node, 0) >= 1)
        printf("%d ", node->item);
    hasGreatGrandchild(node->right);
	return 0;
}

void printSmallerValues(BTNode *node, int m){

	// write your code here
	// inOrder printing
	if (node == NULL) return;
	printSmallerValues(node->left, m);
	if (node->item < m)
        printf("%d ", node->item);
    printSmallerValues(node->right, m);
}

int smallestValue(BTNode *node) {
	int l, r;

	// write your code here
	// define min function
	int min(int a, int b){
	    return (a < b ? a : b);
	}
	if (node == NULL) return ;
	l = ((node->left != NULL) ? smallestValue(node->left) : node->item);
	r = ((node->right != NULL) ? smallestValue(node->right) : node->item);
    return min(node->item, min(l, r));
}


//////////////////////////////////////////////////////////////////

void printTree_InOrder(BTNode *node){

	if (node == NULL) return;
	printTree_InOrder(node->left);
	printf("%d, ", node->item);
	printTree_InOrder(node->right);
	return;
}
