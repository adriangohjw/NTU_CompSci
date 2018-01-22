#include <stdio.h>
int square1(int num);
void square2(int num, int *result);

int main()
{
    int number, result=0;
    printf("Enter the number: \n");
    scanf("%d", &number);
    printf("square1(): %d\n", square1(number));
    square2(number, &result);
    printf("square2(): %d\n", result);
    return 0;
}

int square1(int num)
{
    /* Write your program code here */
    /*  returns the square of a positive integer number num by computing the sum of odd integers */
    int add = 1, total=0;
    for (int i=1; i<=num; i++){
        total += add;
        add += 2;
    }
    return total;
}

void square2(int num, int *result)
{
    /* Write your program code here */
    int add = 1, total=0;
    for (int i=1; i<=num; i++){
        total += add;
        add += 2;
    }
    *result = total;
}
