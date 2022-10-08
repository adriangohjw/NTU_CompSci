#include <stdio.h>
#include <string.h>
#define MAX 100

//structure goes here
typedef struct{
    char name[20]; //a string
    int telno; //an integer with 5 digits
} PhoneBk;

//function declaration goes here
void printPB(PhoneBk *pb, int size);
int readin(PhoneBk *pb);
void search(PhoneBk *pb, int size, char *target);

//main function goes here
int main(){

    //variable declaration goes here
    PhoneBk s[MAX];
    char t[20], *p;
    int size = 0, choice;
    char dummychar;

    //menu goes here
    printf("Select one of the following options: \n");
    printf("1: readin() \n");
    printf("2: search() \n");
    printf("3: printPB() \n");
    printf("4: exit() \n");

    do{

        printf("Enter your choice: \n");
        scanf("%d", &choice);
        scanf("%c", &dummychar);

        switch (choice){
            case 1:
                //scanf("%c", &dummychar);
                size = readin(s);
                break;
            case 2:
                //scanf("%c", &dummychar);
                printf("Enter search name: \n");
                fgets(t, 20, stdin);
                if (p = strchr(t, '\n')){
                    *p = '\0';
                }
                search(s, size, t);
                break;
            case 3:
                printPB(s, size);
                break;

        }

    }while (choice < 4);

    return 0;
}


//functions goes here
//choice 03
void printPB(PhoneBk *pb, int size){

    printf("The phonebook list: \n");
    if (size > 0){
        int i;
        for (i = 0; i < size; i++){
            printf("Name: %s\n", pb[i].name);
            printf("Telno: %d\n", pb[i].telno);
            printf("\n");
        }
    }
    else{
        printf("Empty phonebook \n");
    }
}

//choice 01
int readin(PhoneBk *pb){

    int number_Entered = 0;
    char *p, dummy[20];

    while (1){
        printf("Enter name: \n");
        fgets(pb->name, 20, stdin);

        if (p = strchr(pb->name, '\n')){
            *p = '\0';
        }

        if (strcmp("#", pb->name) == 0){
            break;
        }

        printf("Enter tel: \n");
        scanf("\n");
        scanf("%d", &pb->telno);

        fgets(dummy, 20, stdin);
        
        pb++;
        number_Entered++;
    }
    return number_Entered;
}

//choice 02
void search(PhoneBk *pb, int size, char *target){

    int i;

    for (i = 0; i < size; i++){
        if(strcmp(target, pb[i].name) == 0){
            printf("Name = %s Telno = %d \n", pb[i].name, pb[i].telno);
            return;
        }
    }

    printf("Name not found! \n");

}