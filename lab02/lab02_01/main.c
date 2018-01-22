#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int repeat = 1;

    while (repeat == 1){
        int id, mark;
        char grade;

        printf("Enter Student ID: ");
        scanf("%d", &id);
        if (id == -1) {
            repeat = 0;
            break;
        }

        printf("Enter Mark: ");
        scanf("%d", &mark);

        if (mark >= 75)
            grade = 'A';
        else if (mark >= 65)
            grade = 'B';
        else if (mark >= 55)
            grade = 'C';
        else if (mark >= 45)
            grade = 'D';
        else
            grade = 'F';
        printf("Grade = %c", grade);
    }

    return 0;
}
