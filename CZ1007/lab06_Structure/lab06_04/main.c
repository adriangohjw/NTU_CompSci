#include <stdio.h>
#define INIT_VALUE 1000

typedef struct {
    int id; /* staff identifier */
    int totalLeave; /* the total number of days of leave allowed */
    int leaveTaken; /* the number of days of leave taken so far */
} leaveRecord;
int mayTakeLeave(leaveRecord list[], int id, int leave, int n);
void getInput(leaveRecord list[], int *n);
void printList(leaveRecord list[], int n);

int main()
{
    leaveRecord listRec[10];
    int len;
    int id, leave, canTake=INIT_VALUE;
    int choice;

    printf("\nSelect one of the following options: \n");
    printf("1: getInput()\n");
    printf("2: printList()\n");
    printf("3: mayTakeLeave()\n");
    printf("4: exit()\n");

    do {
        printf("Enter your choice: \n");
        scanf("%d", &choice);
        switch (choice) {
        case 1:
            getInput(listRec, &len);
            break;
        case 2:
            printList(listRec, len);
            break;
        case 3:
            printf("Please input id, leave to be taken: \n");
            scanf("%d %d", &id, &leave);
            canTake = mayTakeLeave(listRec, id, leave, len);
            if (canTake == 1)
                printf("The staff %d can take leave\n", id);
            else if (canTake == 0)
                printf("The staff %d cannot take leave\n", id);
            else if (canTake == -1)
                printf("The staff %d is not in the list\n", id);
            else
                printf("Error!");
            break;
        }
    } while (choice < 4);
    return 0;
}

/* prints the list of leave records of each staff. n is the number of staff in list */
void printList(leaveRecord list[], int n)
{
    int p;
    printf("The staff list:\n");
    for (p = 0; p < n; p++)
        printf ("id = %d, totalleave = %d, leave taken = %d\n",
                list[p].id, list[p].totalLeave, list[p].leaveTaken);
}

/* Each line of the input has three integers representing one staff,
his/her total no. of days of leave allowed and no. of days of leave taken so far
Reads the data into the array list until end of input, returning no. of records read through n. */
void getInput(leaveRecord list[], int *n)
{
    /* Write your program code here */
    printf("Enter the number of staff records: \n");
    scanf("%d", n);
    for (int i=0; i<*n; i++){
        printf("Enter id, totalleave, leavetaken: \n");
        scanf("%d %d %d", &list[i].id , &list[i].totalLeave , &list[i].leaveTaken);
    }
    printf("The staff list: \n");
    for (int i=0; i<*n; i++){
        printf("id = %d, totalleave = %d, leave taken = %d\n",
               list[i].id, list[i].totalLeave, list[i].leaveTaken);
    }
}

/* Returns 1 if a leave application is approved, else 0, -1 if no one in list has identifier id
n is the number of staff in list */
int mayTakeLeave(leaveRecord list[], int id, int leave, int n)
{
    /* Write your program code here */
    for (int i=0; i<n; i++){
        if (list[i].id == id){
            if (list[i].totalLeave - list[i].leaveTaken >= leave){
                return 1;
            } else {
                return 0;
            }
        }
    }
    return -1;
}
