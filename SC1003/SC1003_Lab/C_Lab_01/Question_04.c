#include <stdio.h>
#include <math.h>

int main()
{
    double sum = 1;
    int factorial = 1;
    double user_Input;

    printf("Enter x: \n");
    scanf("%lf",&user_Input);

    for (int i = 1; i <= 10; i++) {
        factorial *= i;
        sum += (pow((double)user_Input, (double)i)/factorial);
    }
    printf("Result = %.2f", sum);
    return 0;

}