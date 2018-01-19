#include <stdio.h>
#include <math.h>

// reads the (x, y) coordinates for two points, computes the distance between the two points.

int main()
{
    float x1, y1, x2, y2;
    printf("Enter first point x1 y1:\n");
    scanf("\n%f %f", &x1, &y1);
    printf("Enter first point x2 y2:\n");
    scanf("\n%f %f", &x2, &y2);

    float distance = sqrt((pow(x1 - x2, 2)) + pow(y1 - y2, 2));
    printf("The distance is %.2f", distance);
    return 0;
}
