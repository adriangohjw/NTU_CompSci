#include <stdio.h>
#include <stdlib.h>

double nrFabs(double result);
double nrSqrt(double square);

int main()
{
    double square;
    printf("Enter number to find square root of (negative no. to end): \n");
    scanf("%lf", &square);
    while (square >= 0){
        printf("The result is %.2f\n", nrSqrt(square));
        printf("Enter number to find square root of (negative number to terminate): \n");
        scanf("%lf", &square);
    }
    return 0;
}

double nrFabs(double result){
    if (result < 0)
        result = (-1) * result;
    return result;
}

double nrSqrt(double square){
    double guess = 0, increment = 1;
    while (nrFabs((guess * guess) - square) > 0.001){
        if ((guess * guess) - square >= 1){
            guess--;
            increment /= 10;
            guess += increment;
        } else
            guess += increment;
    }
    return guess;
}
