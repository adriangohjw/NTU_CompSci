#include <stdio.h>

typedef struct {
    char name[20];
    int age;
} Person;

void readData(Person *p);
Person findMiddleAge(Person *p);

int main()
{
    Person man[3], middle;

    readData(man);
    middle = findMiddleAge(man);
    printf("findMiddleAge(): %s %d\n", middle.name, middle.age);
    return 0;
}

void readData(Person *p)
{
    /* Write your program code here */
    int i;
    for (i=0; i<3; i++){
        printf("Enter person %d:\n", i+1);
        scanf("%s %d", p[i].name, &p[i].age);
    }
}

Person findMiddleAge(Person *p)
{
    /* Write your program code here */
    int midpos;
    if (p[0].age > p[1].age && p[0].age > p[2].age){
        if (p[1].age > p[2].age)
            midpos = 1;
        else
            midpos = 2;
    } else if (p[1].age > p[0].age && p[1].age > p[2].age){
        if (p[0].age > p[2].age)
            midpos = 0;
        else
            midpos = 2;
    } else if (p[2].age > p[0].age && p[2].age > p[1].age){
        if (p[1].age > p[0].age)
            midpos = 1;
        else
            midpos = 0;
    }

    return p[midpos];
}
