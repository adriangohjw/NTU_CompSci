#include <stdio.h>

/*
Write a C program that reads in several lines of non-negative integer numbers,
computes the average for each line and prints out the average.
The value -1 in each line of user input is used to indicate the end of input for that line.
*/

int main()
{
    int total, count, lines, input;
    double average;
    int i;
    printf("Enter number of lines: \n");
    scanf("%d", &lines);

    // your program code here
    for (i=1; i <= lines; i++){
        total = 0;
        count = 0;
        printf("Enter line %d (end with -1): \n", i);
        scanf("%d", &input);
        while (input != -1){
            total += input;
            count++;
            scanf("%d", &input);
        }
        average = (float)total / (float)count;
        printf("Average = %.2f\n", average);
    }

    return 0;
}
