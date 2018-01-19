#include <stdio.h>

int main()
{
    float current, resistance;

    printf("Enter the current:");
    scanf("%f", &current);
    printf("Enter the resistance:");
    scanf("%f", &resistance);

    float power = current * current * resistance;
    printf("The power loss: %.2f", power);

    return 0;
}
