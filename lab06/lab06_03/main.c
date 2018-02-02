#include <stdio.h>
#include <string.h>

struct student{
    char name[20]; /* student name */
    double testScore; /* test score */
    double examScore; /* exam score */
    double total; /* total = (testScore+examScore)/2 */
};
double average();

int main()
{
    printf("average(): %.2f\n", average());
    return 0;
}

/*  creates a database of maximum 50 students using an array of structures.
For each student, it takes in the test score, exam score and compute the total score.
End when the student name is "END", returning the average score of all students */

double average()
{
    /* Write your program code here */
    int count = 0;
    double students_total = 0;  // total score of all students
    char temp;  // buffer

    struct student stud[50];
    while (count < 50){
        printf("Enter student name: \n");
        scanf("%[^\n]", &stud[count].name);
        if (strcmp(stud[count].name, "END")==0){
            break;
        } else {
            printf("Enter test score: \n");
            scanf("%lf", &stud[count].testScore);
            printf("Enter exam score: \n");
            scanf("%lf", &stud[count].examScore);

            // calculate total score of the student
            stud[count].total = (stud[count].examScore + stud[count].testScore) / 2;
            students_total += stud[count].total;  // add to total score
            printf("Student %s total = %.2f\n", stud[count].name, stud[count].total);
        }
        count++;
        scanf("%c", &temp); // temp statement to clear buffer
    }

    if (count == 0){
        return 0;
    } else {
        return students_total / count;
    }
}
