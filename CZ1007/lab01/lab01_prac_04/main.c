#include <stdio.h>
#include <math.h>

// reads the (x, y) coordinates for two points, computes the distance between the two points.

int main()
{
    double x1, y1, x2, y2;
    printf("Enter first point x1 y1:\n");
    scanf("%lf %lf", &x1, &y1);
    printf("Enter second point x2 y2:\n");
    scanf("%lf %lf", &x2, &y2);

    double distance = sqrt((pow(x1 - x2, 2)) + pow(y1 - y2, 2));
    printf("The distance is %.2lf", distance);
    return 0;
}
