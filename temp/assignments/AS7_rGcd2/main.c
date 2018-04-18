#include <stdio.h>

void rGcd2(int num1, int num2, int *result);

int main()
{
    int n1, n2, result;
    printf("Enter 2 numbers: \n");
    scanf("%d %d", &n1, &n2);
    rGcd2(n1, n2, &result);
    printf("rGcd2(): %d\n", result);
    return 0;
}

void rGcd2(int num1, int num2, int *result)
{
    /* recursive function that computes the greatest common divisor
    returns the result to the calling function via call by reference */
    /* Write your code here */
    if (num2 == 0){
        *result = num1;
    } else {
        rGcd2(num2, num1 % num2, result);
    }
}
