#include <stdio.h>
#include <stdlib.h>

typedef struct _listnode{
    int key;
    struct _listnode *next;
} ListNode;

typedef struct _linkedlist{
   int size;
   ListNode *head;
} HashTableNode;

typedef struct _hashTable{
   int hSize; //size of hash table
   int nSize; //number of inserted keys
   HashTableNode *Table;
} HashTable;

int Hash(int,int);

ListNode* HashSearch(HashTable, int);
int HashInsert(HashTable *, int);
int HashDelete(HashTable*, int);

//In Practice, we will not do it
void HashPrint(HashTable);

int main()
{
    int opt;
    int size;

    int i;
    int key;

    //Create a HashTable
    HashTable Q3Hash;
    Q3Hash.hSize = 0; 
    Q3Hash.nSize = 0; 
    Q3Hash.Table = NULL;

    printf("============= Hash Table ============\n");
    printf("|1. Create a hash table             |\n");
    printf("|2. Insert a key to the hash table  |\n");
    printf("|3. Search a key in the hash table  |\n");
    printf("|4. Delete a key in the hash table  |\n");
    printf("|5. Print the hash table            |\n");
    printf("|6. Quit                            |\n");
    printf("=====================================\n");

    printf("Enter selection: ");
    scanf("%d",&opt);
    while(opt>=1 && opt <=5){
        switch(opt){
        case 1:
            printf("Enter the size of hash table:\n");
            scanf("%d",&Q3Hash.hSize);

            Q3Hash.nSize = 0;

            Q3Hash.Table = (HashTableNode *) malloc(sizeof(HashTableNode)*(Q3Hash.hSize));

            for(i=0;i<Q3Hash.hSize;i++){
               Q3Hash.Table[i].head = NULL;
               Q3Hash.Table[i].size = 0;
            }
            printf("HashTable is created.\n");
            break;
        case 2: //Insertion
            printf("Enter a key to be inserted:\n");
            scanf("%d",&key);

            if(HashInsert(&Q3Hash,key))
                printf("%d is inserted.\n",key);
            else
                printf("%d is a duplicate. No key is inserted.\n",key);
            break;
        case 3: //Search
            printf("Enter a key for searching in the HashTable:\n");
            scanf("%d",&key);
            ListNode* node = HashSearch(Q3Hash, key);

            if(node!=NULL)
                printf("%d is found.\n",key);
            else
                printf("%d is not found.\n",key);
            break;
        case 4: //Deletion
            printf("Enter a key to be deleted:\n");
            scanf("%d",&key);
            if(HashDelete(&Q3Hash,key))
                printf("%d is deleted.\n",key);
            else
                printf("%d is not existing.\n",key);
            break;
        case 5:
            HashPrint(Q3Hash);
            break;
        }

    printf("Enter selection: ");
    scanf("%d",&opt);
    }

    for(i=0;i<Q3Hash.hSize;i++)
    {
        while(Q3Hash.Table[i].head)
        {
            ListNode *temp;
            temp = Q3Hash.Table[i].head;
            Q3Hash.Table[i].head = Q3Hash.Table[i].head->next;
            free(temp);
        }
    }
    free(Q3Hash.Table);

    return 0;

}

int Hash(int key,int hSize)
{
    return key%hSize;
}

ListNode* HashSearch(HashTable Q3Hash, int key)
{
    int index;

    ListNode *temp;

    //we may use Q3Hash.Table != NULL
    if(Q3Hash.hSize!=0)
      index = Hash(key,Q3Hash.hSize);
    else
      return NULL;

    temp = Q3Hash.Table[index].head;
    while(temp !=NULL){
        if(temp->key == key)
            return temp;
        temp = temp->next;
    }
    return NULL;
}

int HashInsert(HashTable* Q3HashPtr, int key)
{
    int index;
    ListNode *newNode;

    if(HashSearch(*Q3HashPtr, key)!=NULL)   //duplicate
        return 0;

    if(Q3HashPtr->hSize!=0)
        index  = Hash(key,Q3HashPtr->hSize);

    //The key is inserted from the front. It is not the same approach discussed in lecture
    newNode = (ListNode *) malloc(sizeof(ListNode));
    newNode->key = key;
    newNode->next= Q3HashPtr->Table[index].head;
    Q3HashPtr->Table[index].head = newNode;

    Q3HashPtr->Table[index].size++;
    Q3HashPtr->nSize++;

    return 1; //insertion is done successfully

}

int HashDelete(HashTable* Q3HashPtr, int key)
{
    // Write your code here.
    int index;
    ListNode* prevNode = NULL;
    ListNode* tempNode = NULL;
    ListNode* nextNode = NULL;

    if(HashSearch(*Q3HashPtr, key) == NULL){
        return 0;
    }

    if(Q3HashPtr->hSize!=0){
        index  = Hash(key,Q3HashPtr->hSize);
    }
        
    tempNode = Q3HashPtr->Table[index].head;
    while(tempNode !=NULL){
        nextNode = tempNode->next;
        if(tempNode->key == key){
            if(prevNode == NULL){
                Q3HashPtr->Table[index].head = nextNode;
            }
            else{
                prevNode->next = nextNode;
            }
            return 1;
        }
        prevNode = tempNode;
        tempNode = tempNode->next;
    }
}

void HashPrint(HashTable Q3Hash)
{
    int i;
    ListNode *temp;
    for(i=0;i<Q3Hash.hSize;i++)
    {
        temp =Q3Hash.Table[i].head;
        printf("%d:  ",i);
        while(temp !=NULL)
        {
            printf("%d -> ", temp->key);
            temp = temp->next;
        }
        printf("\n");
    }
}