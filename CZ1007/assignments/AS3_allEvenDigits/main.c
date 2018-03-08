#include <stdio.h>
#define INIT_VALUE -1
int allEvenDigits1(int num);
void allEvenDigits2(int num, int *result);

int main()
{
    int number, result = INIT_VALUE;

    printf("Enter a number: \n");
    scanf("%d", &number);
    printf("allEvenDigits1(): ");
    result = allEvenDigits1(number);
    if (result == 1)
        printf("All Even\n");
    else if (result == 0)
        printf("Not All Even\n");
    else
        printf("Error\n");
    allEvenDigits2(number, &result);
    printf("allEvenDigits2(): ");
    if (result == 1)
        printf("All Even\n");
    else if (result == 0)
        printf("Not All Even\n");
    else
        printf("Error\n");
    return 0;
}

int allEvenDigits1(int num)
{
    /* returns either 1 if all digits even, else 0 */
    /* Write your program code here */
    int even = 1;
    while (num != 0){
        if (num % 2 == 1){
            even = 0;
            break;
        }
        num /= 10;
    }

    return even;
}

void allEvenDigits2(int num, int *result)
{
    /* Write your program code here */
    int even = 1;
    while (num != 0){
        if (num % 2 == 1){
            even = 0;
            break;
        }
        num /= 10;
    }

    *result = even;
}
