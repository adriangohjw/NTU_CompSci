#include <stdio.h>
#include <string.h>
#define MAX 5

//structure goes here
typedef struct {
    int nameCardID;
    char personName[20];
    char companyName[20];
} NameCard;

//function declaration goes here
//choice 01
void listNameCards(NameCard *name_Card, int size);
//choice 02
int addNameCard(NameCard *name_Card, int size);
//choice 03
int removeNameCard(NameCard *name_Card, int size);
//choice 04
void getNameCard(NameCard *name_Card, int size);
//sorting algo
void sortAsc(NameCard *name_Card, int size);

int main() {
    
    NameCard name_Card[MAX];
    char *p;
    char dummy;
    int size = 0, choice;
    
    //menu goes here
    printf("NTU NAME CARD HOLDER MANAGEMENT PROGRAM: \n");
    printf("1: listNameCards() \n");
    printf("2: addNameCard() \n");
    printf("3: removeNameCard() \n");
    printf("4: getNameCard() \n");
    printf("5: quit \n");
    
    do{
        printf("Enter your choice: \n");
        scanf("%d", &choice);
        scanf("%c", &dummy);
        
        switch (choice){
            case 1:
                listNameCards(name_Card, size);
                break;
            case 2:
                size = addNameCard(name_Card, size);
                break;
            case 3:
                size = removeNameCard(name_Card, size);
                break;
            case 4:
                getNameCard(name_Card, size);
                break;
            
        }
    } while (choice < 5);
    
    return 0;
}

//function goes here

//choice 01
void listNameCards(NameCard *name_Card, int size){
    printf("listNameCards(): \n");
    
    if (size > 0){

        int i;
        for (i = 0; i < size; i++){
            printf("nameCardID: %d \n", name_Card[i].nameCardID);
            printf("personName: %s \n", name_Card[i].personName);
            printf("companyName: %s \n", name_Card[i].companyName);
        }
    }
    else{
        printf("The name card holder is empty \n");
    }
}

//choice 02
int addNameCard(NameCard *name_Card, int size){
    printf("addNameCard(): \n");

    int i, card_ID;
    char personName[20], companyName[20], dummy[20], *p;

    printf("Enter nameCardID: \n");
    scanf("%d", &card_ID);
    //fgets(dummy, 20, stdin);
    scanf("%c", &dummy);

    printf("Enter personName: \n");
    fgets(personName, 20, stdin);
    if (p = strchr(personName, '\n')){
        *p = '\0';
    }

    printf("Enter companyName: \n");
    fgets(companyName, 20, stdin);
    if (p = strchr(companyName, '\n')){
        *p = '\0';
    }

    if (size == MAX){
        printf("The name card holder is full \n");
        return size;
    }

    for (i = 0; i < size; i++){
        if (card_ID == name_Card[i].nameCardID){
            printf("The nameCardID has already existed \n");
            return size;
        }
    }

    name_Card[size].nameCardID = card_ID;
    strcpy(name_Card[size].personName, personName);
    strcpy(name_Card[size].companyName, companyName);
    
    printf("The name card has been added successfully \n");

    size++;
    sortAsc(name_Card, size);
    return size;
}

//choice 03
int removeNameCard(NameCard *name_Card, int size){
    printf("removeNameCard(): \n");

    char search[20], *p;

    printf("Enter personName: \n");

    fgets(search, 20, stdin);

    if (p = strchr(search, '\n')){
        *p = '\0';
    }

    int i;

    if (size == 0){
        printf("The name card holder is empty \n");
        return size;
    }

    for (i = 0; i < size; i++){
        if (strcasecmp(search, name_Card[i].personName) == 0){
            
            printf("The name card is removed \n");
            printf("nameCardID: %d \n", name_Card[i].nameCardID);
            printf("personName: %s \n", name_Card[i].personName);
            printf("companyName: %s \n", name_Card[i].companyName);
            
            name_Card[i].nameCardID = 0;
            strcpy(name_Card[i].personName, "");
            strcpy(name_Card[i].companyName, "");
            
            size--;
            sortAsc(name_Card, size);
            return size;
        }
    }
    printf("The target person name is not in the name card holder \n");
    return size;
}

//choice 04
void getNameCard(NameCard *name_Card, int size){
    printf("getNameCard(): \n");

    int i; 
    char search[20], *p;

    printf("Enter personName: \n");

    fgets(search, 20, stdin);

    if (p = strchr(search, '\n')){
        *p = '\0';
    }

    for (i = 0; i < size; i++){
        if (strcasecmp(search, name_Card[i].personName) == 0){
            printf("The target person name is found \n");
            printf("nameCardID: %d \n", name_Card[i].nameCardID);
            printf("personName: %s \n", name_Card[i].personName);
            printf("companyName: %s \n", name_Card[i].companyName);
            return;
        }
    }
    printf("The target person name is not found \n");

}

//sorting algo
void sortAsc(NameCard *name_Card, int size){

    NameCard temp;
    int i, j;
    for (i = 0; i < (size - 1); i++){
        for (j = 0; j < (size - 1 - i); j++){
            if (name_Card[j].nameCardID > name_Card[j + 1].nameCardID){
                temp = name_Card[j];
                name_Card[j] = name_Card[j + 1];
                name_Card[j + 1] = temp;
            }
        }
    }
}