#include <stdio.h>

void rCountZeros2(int num, int *result);

int main()
{
    int number, result;
    printf("Enter the number: \n");
    scanf("%d", &number);
    rCountZeros2(number,&result);
    printf("rCountZeros2(): %d\n", result);
    return 0;
}

void rCountZeros2(int num, int *result)
{
    /* Write your program code here */
    if (num == 0)
        *result = 1;
    else if (num > 0 && num < 10)
        *result = 0;
    else {
        rCountZeros2(num/10, result);
        if (num % 10 == 0)
            (*result)++;
    }
}
