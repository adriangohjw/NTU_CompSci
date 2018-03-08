#include <stdio.h>
#define INIT_VALUE 0

int extOddDigits1(int num);
void extOddDigits2(int num, int *result);

int main()
{
    int number, result = INIT_VALUE;

    printf("Enter a number: \n");
    scanf("%d", &number);
    printf("extOddDigits1(): %d\n", extOddDigits1(number));
    extOddDigits2(number, &result);
    printf("extOddDigits2(): %d\n", result);
    return 0;
}

int extOddDigits1(int num)
{
    /* Extracts odd digits from a positive number and return the new number */
    /* returns -1 if no odd digits */
    /* Write your program code here */
    int sum = 0, count = 1;
    while (num != 0){
        if (num % 2 == 1){
            sum += ((num % 10) * count);
            count *= 10;
        }
        num /= 10;
    }

    if (count == 1) {
        return -1;
    } else {
        return sum;
    }
}

void extOddDigits2(int num, int *result)
{
    /* Write your program code here */
    /* returns the result through the pointer parameter, result */

    int sum = 0, count = 1;
    while (num != 0){
        if (num % 2 == 1){
            sum += ((num % 10) * count);
            count *= 10;
        }
        num /= 10;
    }

    if (count == 1) {
        *result = -1;
    } else {
        *result = sum;
    }
}
