#include <stdio.h>

/* a RECURSIVE function that returns the square of a positive integer number num,
by computing the sum of odd integers starting with 1
For example, if num = 4, then 4^2 = 1 + 3 + 5 + 7 = 16 is returned */

int rSquare1(int num);
void rSquare2(int num, int *result);

int main()
{
    int number, result=0;
    printf("Enter the number: \n");
    scanf("%d", &number);
    printf("rSquare1(): %d\n", rSquare1(number));
    rSquare2(number, &result);
    printf("rSquare2(): %d\n", result);
    return 0;
}

int rSquare1(int num)
{
    /* Write your program code here */
    if (num == 0){
        return 0;
    } else {
        return ((2 * num) - 1) + rSquare1(num-1);
    }
}

void rSquare2(int num, int *result)
{
    /* Write your program code here */
    if (num > 0){
        *result += (num * 2) - 1;
        rSquare2(num-1, result);
    }
}
