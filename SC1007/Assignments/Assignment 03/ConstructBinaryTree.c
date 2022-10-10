#include <stdio.h>
#include <stdlib.h>

#define MAX_N 120

typedef struct _btnode{
    char id;
    struct _btnode *left;
    struct _btnode *right;
} BTNode;

void buildTree(BTNode** node, char* preO, char* postO);
void inOrder(BTNode *cur);
void preOrder(BTNode *cur);
void postOrder(BTNode *cur);

int main()
{
    char preO[MAX_N];
    char postO[MAX_N];
    scanf("%s",preO);
    scanf("%s",postO);

    BTNode* root=NULL;
    buildTree(&root,preO,postO);
    if(root==NULL) printf("error\n");
    preOrder(root);
    printf("\n");
    postOrder(root);
    printf("\n");

    inOrder(root);
    printf("\n");

    return 0;
}
void inOrder(BTNode *cur){
    if (cur == NULL)
        return;

    inOrder(cur->left);
    printf("%c",cur->id);
    inOrder(cur->right);
}
void preOrder(BTNode *cur){
    if (cur == NULL)
        return;

    printf("%c",cur->id);
    preOrder(cur->left);
    preOrder(cur->right);
}
void postOrder(BTNode *cur){
    if (cur == NULL)
        return;

    postOrder(cur->left);
    postOrder(cur->right);
    printf("%c",cur->id);
}

void buildTree(BTNode** node, char* preO, char* postO)
{

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


// Write your code here
    *node = malloc(sizeof(*node));
    int preTotalNum = 0;
    int i, j = 0;

    while(preO[preTotalNum] != '\0'){
        preTotalNum++;
    }
    if (preTotalNum == 0){
        (*node) = NULL;
        return;
    }
    (*node)->id = preO[0];
    
    if(preTotalNum == 1){
        ((*node)->left) = NULL;
        ((*node)->right) = NULL;
        return;
    }
    else{
        char newPreO[MAX_N];
        char newPostO[MAX_N];
        char leftPreO[MAX_N];
        char rightPreO[MAX_N];
        char leftPostO[MAX_N];
        char rightPostO[MAX_N];

        int leftPostOCount = 0;
        int leftPostOFlag = 0;
        int leftPreOFlag = 0;

        //Removes the character that matches the root (i.e., 1st char) from the PreOrder, stores new String in newPreO.
        j = 0;
        for(i = 0; preO[i] != '\0'; i++){
            if (preO[i] != (*node)->id){
                newPreO[j] = preO[i];
                j++;
            }
        }
        newPreO[j] = '\0';

        //Removes the character that matches the root (i.e., last char) from the PostOrder, stores new String in newPostO.
        j = 0;
        for(i = 0; postO[i] != '\0'; i++){
            if (postO[i] != (*node)->id){
                newPostO[j] = postO[i];
                j++;
            }
        }
        newPostO[j] = '\0';

        //Splits the newPostO into a Left and Right String. LeftPostO string will be parsed to node->left, while RightPostO will be parsed to node->right
        j = 0;
        for (i = 0; newPostO[i] != '\0'; i++){
            if(leftPostOFlag == 0){
                leftPostO[leftPostOCount] = newPostO[i];
                leftPostOCount++;
                if (newPostO[i] == newPreO[0]){
                    leftPostOFlag = 1;
                }
            }
            else{
                rightPostO[j] = newPostO[i];
                j++;
            }
        }
        leftPostO[leftPostOCount] = '\0';
        rightPostO[j] = '\0';

        //Splits the newPreO into a Left and Right String. LeftPreO string will be parsed to node->left, while RightPreO will be parsed to node->right
        j = 0;
        for (i = 0; newPreO[i] != '\0'; i++){
            if(leftPreOFlag == 0){
                leftPreO[i] = newPreO[i];
                if (i == (leftPostOCount-1)){
                    leftPreOFlag = 1;
                }
            }
            else{
                rightPreO[j] = newPreO[i];
                j++;
            }
        }
        leftPreO[leftPostOCount] = '\0';
        rightPreO[j] = '\0';

        buildTree((&(*node)->left), leftPreO, leftPostO);
        buildTree((&(*node)->right), rightPreO, rightPostO);
        return;
    }
}