#include <stdio.h>

/*
The salary scheme for a company is given as follows:
    Salary range for grade A: $700 - $899
    Salary range for grade B: $600 - $799
    Salary range for grade C: $500 - $649

In addition, a person whose salary is between $600 and $649 is in grade C if his merit points are
below 10, otherwise he is in grade B.

A person whose salary is between $700 and $799 is in grade B if his merit points are below 20,
otherwise he is in grade A.

Write a program to read in a person's salary and his merit points, and displays his grade.
*/

int main()
{
    int salary, merit;

    printf("Enter the salary: \n");
    scanf("%d", &salary);
    printf("Enter the merit: \n");
    scanf("%d", &merit);

    char grade;

    /* Write your program code here */
    if (salary <= 649){

        if (600 <= salary && 10 <= merit)
            grade = 'B';
        else
            grade = 'C';

    } else if (salary <= 799) {

        if (700 <= salary && 20 <= merit)
            grade = 'A';
        else
            grade = 'B';

    } else {

        grade = 'A';

    }

    printf("%c", grade);

    return 0;
}
