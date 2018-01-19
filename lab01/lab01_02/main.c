#include <stdio.h>
#include <stdlib.h>

/*
Computing linear equations

a1x + b1y = c1
a2x + b2y = c2

The program reads in a1, b1, c1, a2, b2 and c2, and then computes and prints the solutions.
Assumption: denominator (a1b2 - a2b1) of the above equations is not zero.
*/

int main()
{
    float a1, b1, c1, a2, b2, c2;

    printf("Enter the values for a1, b1, c1, a2, b2, c2: ");
    scanf("%f %f %f %f %f %f", &a1, &b1, &c1, &a2, &b2, &c2);

    float x = ((b2 * c1) - (b1 * c2)) / ((a1 * b2) - (a2 * b1));
    float y = ((a1 * c2) - (a2 * c1)) / ((a1 * b2) - (a2 * b1));

    printf("x = %.2f and y = %.2f", x, y);


    return 0;
}
