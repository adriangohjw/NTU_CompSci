#include <stdio.h>
#include <string.h>
#define SIZE 50

typedef struct {
    int id;
    char name[50];
} Student;

void inputStud(Student *s, int size);
void printStud(Student *s, int size);
int removeStud(Student *s, int *size, char *target);

int main()
{
    Student s[SIZE];
    int size=0, choice;
    char target[80];
    int result;
    printf("Select one of the following options: \n");
    printf("1: inputStud()\n");
    printf("2: removeStud()\n");
    printf("3: printStud()\n");
    printf("4: exit()\n");

    do {
        printf("Enter your choice: \n");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("Enter size: \n");
            scanf("%d", &size);
            printf("Enter %d students: \n", size);
            inputStud(s, size);
            break;
        case 2:
            printf("Enter name to be removed: \n");
            scanf("\n");
            gets(target);
            printf("removeStud(): ");
            result = removeStud(s, &size, target);
            if (result == 0)
                printf("Successfully removed\n");
            else if (result == 1)
                printf("Array is empty\n");
            else if (result == 2)
                printf("The target does not exist\n");
            else
                printf("An error has occurred\n");
            break;
        case 3:
            printStud(s, size);
            break;
        }
    } while (choice < 4);
    return 0;
}

void inputStud(Student *s, int size)
{
    /* reads in students' information according to an input student size. */
    /* write your code here */
    int i;
    for (i=0; i<size; i++){
        printf("Student ID:\n");
        scanf("%d", &s[i].id);

        printf("Student Name:\n");
        scanf("\n");
        gets(s[i].name);
    }
}

void printStud(Student *s, int size)
{
    /* write your code here */
    printf("The current student list:\n");
    if (size != 0){
        int i;
        for (i=0; i<size; i++){
            printf("Student ID: %d Student Name: %s\n", s[i].id, s[i].name);
        }
    } else {
        printf("Empty array\n");
    }
}

int removeStud(Student *s, int *size, char *target)
{
    /* removes the target student name from the array which has *size numbers in it.
    If *size == 0, the function issue an error message "Array is empty".
    If target name not in the array, the function issue an error message "The target does not exist" */
    /* write your code here */
    if (*size == 0){
        return 1;  // array is empty
    } else if (*size > 0) {
        int i, j;
        for (i=0; i<*size; i++){  // i is location of student in array
            if (strcmp(s[i].name, target)==0){  // if student[i] matches input name (target)
                s[i].id = '\0';
                s[i].name[0] = '\0';
                for(j=i; j<*size-1; j++){
                    s[j].id = s[j+1].id;
                    strcpy(s[j].name, s[j+1].name);
                }
                s[*size-1].id = '\0';
                s[*size-1].name[0] = '\0';
                *size -= 1;
                return 0;
            }
        }
        return 2;  // does not exist (no match)
    } else {
        return -1;
    }
}
