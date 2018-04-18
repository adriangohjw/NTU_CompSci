#include <stdio.h>

/* RECURSIVE function that returns the position of the first appearance of a specified digit
in a positive number. The position of the digit is counted from the right and starts from 1.
If the required digit is not in the number, the function should return 0 */

int rDigitPos1(int num, int digit);
void rDigitPos2(int num, int digit, int *pos);

int main()
{
    int number, digit, result=0;
    printf("Enter the number: \n");
    scanf("%d", &number);
    printf("Enter the digit: \n");
    scanf("%d", &digit);
    printf("rDigitPos1(): %d\n", rDigitPos1(number, digit));
    rDigitPos2(number, digit, &result);
    printf("rDigitPos2(): %d\n", result);
    return 0;
}

int rDigitPos1(int num, int digit)
{
    /* Write your program code here */
    if (num == 0){  // terminating case
        return 0;
    } else if (num % 10 == digit){  // if match with digit
        return 1;
    }

    if (rDigitPos1(num/10, digit) == 0){
        return 0;
    } else {
        return 1 + rDigitPos1(num/10, digit);
    }
}

void rDigitPos2(int num, int digit, int *pos)
{
    /* Write your program code here */
    (*pos)++;
    if (num / 10 == 0)
        *pos = 0;
    else if (num % 10 != digit)
        rDigitPos2(num/10, digit, pos);
}
