#include <stdio.h>
#include <stdlib.h>

typedef struct _dbllistnode
{
    int  item;
	struct _dbllistnode *next;
	struct _dbllistnode *pre;
} CDblListNode;

typedef struct _dbllinkedlist{
   int size;
   CDblListNode *head;
} CDblLinkedList;

void insertNode_AtFront(CDblLinkedList *ptrCDLL, int value);
void deleteList(CDblLinkedList *ptrCDLL);
void printList(CDblLinkedList CDLL);

int numMountainPairs(CDblLinkedList CDLL);

int main()
{
    CDblLinkedList himalayas;
    himalayas.head = NULL;
    himalayas.size = 0;

    int item;
    int i,cases;
    int numP;
    scanf("%d",&cases);
    for(i=0; i<cases; i++)
    {
        while(scanf("%d",&item))
            insertNode_AtFront(&himalayas, item);
        scanf("%*s");

        numP = numMountainPairs(himalayas);
        printList(himalayas);
        printf("%d Pairs.\n",numP);

        deleteList(&himalayas);
    }
    return 0;
}

void insertNode_AtFront(CDblLinkedList *ptrCDLL, int value){
      //create a new node
      CDblListNode* newNode;
      newNode = (CDblListNode *) malloc(sizeof(CDblListNode));
      newNode->item = value;

      if(ptrCDLL->size==0) //first node
      {
          newNode->next = newNode;
          newNode->pre = newNode;
          ptrCDLL->head = newNode;
      }
      else{
        newNode->next = ptrCDLL->head;
        newNode->pre = ptrCDLL->head->pre;

        newNode->pre->next = newNode; //update last node next link;
        ptrCDLL->head->pre = newNode;

        ptrCDLL->head = newNode;
      }
      ptrCDLL->size++;
}

void printList(CDblLinkedList CDLL){

    if(CDLL.head==NULL) return;

    CDblListNode* temp = CDLL.head;
    printf("Current List: ");

    while (temp->next != CDLL.head){
        printf("%d ", temp->item);
        temp = temp->next;

    }
    printf("%d\n",temp->item);
}

void deleteList(CDblLinkedList *ptrCDLL){
    if(ptrCDLL->head==NULL) return;
    CDblListNode *cur = ptrCDLL->head;
    CDblListNode *temp;

    while (cur->next!= ptrCDLL->head) {
        temp=cur->next;
        free(cur);
        cur=temp;
    }

    free(cur);
    ptrCDLL->head =NULL;
    ptrCDLL->size =0;

}



int numMountainPairs(CDblLinkedList CDLL)
{
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

// Write your code here
    int extraMountains = 0;
    int duplicatePairs = 0;
    int height = 0;

    CDblListNode* tracker = CDLL.head; 
    CDblListNode* temp = tracker->next;
    CDblListNode* duplicate = tracker;

    if(CDLL.size <= 2){
        return (CDLL.size)-1;
    }
    else{
        for (int i = 0; i < (CDLL.size); i++){
            while(temp->next != tracker){
                if (tracker->item >= tracker->next->item){
                    if((temp != tracker->pre) && (temp != tracker->next)){
                        if((temp->item >= temp->pre->item) && (tracker->item >= temp->pre->item) && (temp->item >= height)){
                            extraMountains += 1;

                            duplicate = temp->next;
                            while(duplicate != tracker){
                                if(temp->item >= temp->next->item){
                                    if((duplicate->item <= tracker->item) && (duplicate->item <= temp->item)){
                                        if ((duplicate->next == tracker)){
                                            duplicatePairs += 1;
                                        }
                                    }
                                    else{
                                        break;
                                    }
                                }
                                else{
                                    break;
                                }
                                duplicate = duplicate->next;
                            }
                        
                        }
                        if(temp->item > tracker->item){
                            break;
                        }
                    }
                }
                else{
                    break;
                }
                if(height < temp->item){
                    height = temp->item;
                }
                temp = temp->next;
            }
            tracker = tracker->next;
            temp = tracker->next;
            height = 0;
        }
        return (CDLL.size) + extraMountains - (duplicatePairs/2);
    }
}