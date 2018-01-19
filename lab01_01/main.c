#include <stdio.h>
#include <stdlib.h>

int main()
{
    float Celcius, Fahrenheit;

    printf("Enter temperature (Fahrenheit) to be converted: \n");
    scanf("%f", &Fahrenheit);

    Celcius = (Fahrenheit - 32) * (5.0/9.0);
    printf("Degree in Celcius: %.2f", Celcius);

    return 0;

}
