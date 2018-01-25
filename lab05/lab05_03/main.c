/* C program that reads and searches character strings. */

#include <stdio.h>
#include <string.h>
#define SIZE 10
#define INIT_VALUE 999

void printNames(char nameptr[][80], int size);
void readNames(char nameptr[][80], int *size);

/* searches whether a target name string has been stored in the array of strings.
<string> target is the target string
<array> nameptr is the array of strings,
<int> size is the number of names stored in the array
If the target string is found, the function will return its index location, or -1 if otherwise.
In addition, it also contains the function readNames() that reads a number of names from the user. */
int findTarget(char *target, char nameptr[][80], int size);

int main() {
    char nameptr[SIZE][80], t[40];
    int size, result = INIT_VALUE;
    int choice;

    printf("\nSelect one of the following options: \n");
    printf("1: readNames()\n");
    printf("2: findTarget()\n");
    printf("3: printNames()\n");
    printf("4: exit()\n");
    do {
        printf("Enter your choice: \n");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                readNames(nameptr, &size);
                break;
            case 2:
                printf("Enter target name: \n");
                scanf("\n");
                gets(t);
                result = findTarget(t, nameptr, size);
                printf("findTarget(): %d\n", result);
                break;
            case 3:
                printNames(nameptr, size);
                break;
        }
    } while (choice < 4);
    return 0;
}

void printNames(char nameptr[][80], int size)
{
    /* Write your program code here */
    for (int i=0; i < size; i++)
        printf("%s ", nameptr[i]);
    printf("\n");
}

void readNames(char nameptr[][80], int *size)
{
    /* Write your program code here */
    printf("Enter size:\n");
    scanf("%d", size);
    printf("Enter %d names:\n", *size);
    for (int i=0; i<*size; i++){
        scanf("%s", nameptr[i]);
    }
}

int findTarget(char *target, char nameptr[][80], int size)
{
    /* Write your program code here */
    int position = -1;
    for (int i=0; i < size; i++){
        if (strcmp(target, nameptr[i]) == 0)
            position = i;
    }
    return position;
}
