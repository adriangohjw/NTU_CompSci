#include <stdio.h>
int divide1(int m, int n, int *r);
int divide2(int m, int n, int *q, int *r);

int main()
{
    int m, n, q, r;

    printf("Enter two numbers (m and n): \n");
    scanf("%d %d", &m, &n);
    q = divide1(m, n, &r);
    printf("divide1(): quotient %d remainder %d\n", q, r);
    divide2(m, n, &q, &r);
    printf("divide2(): quotient %d remainder %d\n", q, r);
    return 0;
}

int divide1(int m, int n, int *r)
{
    /* performs integer division by subtraction */
    /* computes the quotient and remainder of dividing m by n */
    /* are not allowed to use the division (/) and modulus (%) operators. */
    /* Write your program code here */
    int count = 0;
    while ((m-n) > 0){
        count++;
        m -= n;
    }
    *r = m;
    return count;
}

int divide2(int m, int n, int *q, int *r)
{
    /* Write your program code here */
    int count = 0;
    while ((m-n) > 0){
        count++;
        m -= n;
    }
    *r = m  ;
    *q = count;
}
