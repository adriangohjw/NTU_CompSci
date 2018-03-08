#include <stdio.h>
#include <string.h>
#define MAX 100

typedef struct {
    char name[40];
    char telno[40];
    int id;
    double salary;
} Employee;

int readin(Employee *p);
void printEmp(Employee *p, int size) ;
int search(Employee *p, int size, char *target);
int addEmployee(Employee *p, int size, char *target);

int main()
{
    Employee emp[MAX];
    char name[10];
    int k, size, found=0, ans, choice, result;
    printf("Select one of the following options: \n");
    printf("1: readin()\n");
    printf("2: search()\n");
    printf("3: addEmployee()\n");
    printf("4: print()\n");
    printf("5: exit()\n");
    do {
        printf("Enter your choice: \n");
        scanf("%d", &choice);
        switch (choice) {
        case 1:
            size = readin(emp);
            break;
        case 2:
            printf("Enter search name: \n");
            scanf("\n");
            gets(name);
            result = search(emp,size,name);
            if (result != 1)
                printf ("Name not found!\n");
            break;
        case 3:
            printf("Enter new name: \n");
            scanf("\n");
            gets(name);
            result = search(emp,size,name);
            if (result != 1)
                size = addEmployee(emp, size, name);
            else
                printf("The new name has already existed in the database");
            break;
        case 4:
            printEmp(emp, size);
            break;
        default:
            break;
        }
    } while (choice < 5);
    return 0;
}

int readin(Employee *p)
{
    /* character '#' is used to indicate the end of user input. */
    /* write your code here */
    int size = 0;
    char c;

    printf("Enter name:\n");
    scanf("\n");
    gets(p[size].name);

    while (strcmp(p[size].name, "#") != 0){

        printf("Enter tel: \n");
        scanf("\n");
        gets(p[size].telno);

        printf("Enter id: \n");
        scanf("%d", &p[size].id);

        printf("Enter salary: \n");
        scanf("%lf", &p[size].salary);

        size++;

        printf("Enter name:\n");
        scanf("\n");
        gets(p[size].name);
    }
    return size;
}

void printEmp(Employee *p, int size)
{
    /* write your code here */
    printf("The current employee list: \n");
    for (int i=0; i<size; i++){
        printf("%s %s %d %.2f\n", p[i].name, p[i].telno, p[i].id, p[i].salary);
    }
}

int search(Employee *p, int size, char *target)
{
    /* write your code here */
    for (int i=0; i<size; i++){
        if (strcmp(p[i].name, target) == 0){
            printf("Employee found at index location: %d\n", i);
            printf("%s %s %d %.2f\n", p[i].name, p[i].telno, p[i].id, p[i].salary);
            return 1;
        }
    }
    return -1;  // not found
}

int addEmployee(Employee *p, int size, char *target)
{
    /* write your code here */
    if (size == 99){
        printf("Database is full\n");
    } else {
        int count = 0;
        while (*(target+count) != '\0'){
            p[size].name[count] = *(target+count);
            count++;
        }
        p[size].name[count] = '\0';

        printf("Enter tel: \n");
        scanf("\n");
        gets(p[size].telno);

        printf("Enter id: \n");
        scanf("%d", &p[size].id);

        printf("Enter salary: \n");
        scanf("%lf", &p[size].salary);

        printf("Added at position: %d\n", size);
        size++;
    }
    return size;
}
