#include <stdio.h>
int main()
{
    int score, student_ID;
    char grade;


    printf("Enter Student ID: \n");
    scanf("%d", &student_ID);


    while (student_ID != -1) {
        printf("Enter Mark: \n");
        scanf("%d", &score);
    

        if (0 <= score && score <= 100) {
            
            if (score >= 75) {
                grade = 'A';
            }
            else if (score >= 65) {
                grade = 'B';
            }
            else if (score >= 55) {
                grade = 'C';
            }
            else if (score >= 45) {
                grade = 'D';
            }
            else {
                grade = 'F';
            }

            printf("Your student ID is %d and your grade is %c \n", student_ID, grade);

        }
        else {
            printf("The value you have entered should be between 0 and 100\n");
        }
        
        printf("Enter Student ID: \n");
        scanf("%d", &student_ID);

    }
    return 0;
}