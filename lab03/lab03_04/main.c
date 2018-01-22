#include <stdio.h>
#include <math.h>

/*
Accepts four decimal values representing the coordinates of two points on a plane,
and calculates and displays the distance between the points:
*/

void inputXY(double *x1, double *y1, double *x2, double *y2);
void outputResult(double dist);
double calDistance1(double x1, double y1, double x2, double y2);
void calDistance2(double x1, double y1, double x2, double y2, double *dist);

int main()
{
    double x1, y1, x2, y2, distance=-1;

    inputXY(&x1, &y1, &x2, &y2); // call by reference
    distance = calDistance1(x1, y1, x2, y2); // call by value
    printf("calDistance1(): \n");
    outputResult(distance);
    calDistance2(x1, y1, x2, y2, &distance); // call by reference
    printf("calDistance2(): \n");
    outputResult(distance); // call by value
    return 0;
}

void inputXY(double *x1, double *y1, double *x2, double *y2)
{
    printf("Input x1 y1 x2 y2: \n");
    scanf("%lf %lf %lf %lf", &*x1, &*y1, &*x2, &*y2);
}

void outputResult(double dist)
{
    printf("%.2f\n", dist);
}

double calDistance1(double x1, double y1, double x2, double y2)
{
    double x_diff = pow((x2-x1), 2);
    double y_diff = pow((y2-y1), 2);
    return sqrt(x_diff + y_diff);
}

void calDistance2(double x1, double y1, double x2, double y2, double *dist)
{
    double x_diff = pow((x2-x1), 2);
    double y_diff = pow((y2-y1), 2);
    *dist = sqrt(x_diff + y_diff);
}
