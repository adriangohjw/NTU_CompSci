#include <stdio.h>

int rAllOddDigits1(int num);

int main()
{
    int number;
    printf("Enter a number: \n");
    scanf("%d", &number);
    printf("rAllOddDigits1(): %d\n", rAllOddDigits1(number));
    return 0;
}

int rAllOddDigits1(int num)
{
    /* Write your code here */
    if (num/2 * 2 == num)  // return 0 if LSB is even
        return 0;
    else if (num < 10)
        return 1;
    else
        return rAllOddDigits1(num/10);
}
