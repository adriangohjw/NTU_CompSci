#include <stdio.h>
int digitPos1(int num, int digit);
void digitPos2(int num, int digit, int *result);

int main()
{
    int number, digit, result=0;
    printf("Enter the number: \n");
    scanf("%d", &number);
    printf("Enter the digit: \n");
    scanf("%d", &digit);
    printf("digitPos1(): %d\n", digitPos1(number, digit));
    digitPos2(number, digit, &result);
    printf("digitPos2(): %d\n", result);
    return 0;
}

int digitPos1(int num, int digit)
{
    /* Write your program code here */
    /* returns the position of the first appearance of a specified digit in a positive number */
    int count = 0;
    int complete = 0;
    while (num) {
        if (num % 10 == digit){
            count++;
            complete = 1;
            break;
        } else
            num /= 10;
    }
    if (complete)
        return count;
    else
        return 0;
}

void digitPos2(int num, int digit, int *result)
{
    /* Write your program code here */
    int count = 1;
    int complete = 0;
    while (num) {
        if (num % 10 == digit){
            count++;
            complete = 1;
            break;
        } else
            num /= 10;
    }
    if (complete)
        *result = count;
    else
        *result = 0;
}
