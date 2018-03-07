#include <stdio.h>
#include <stdlib.h>

int factorial(int n);

int main()
{
    int n;
    printf("Enter number:\n");
    scanf("%d", &n);
    printf("%d", factorial(n));
    return 0;
}

int factorial(int n){
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n-1);
    }
}
