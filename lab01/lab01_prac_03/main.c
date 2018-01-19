#include <stdio.h>

/*
Read the time (in seconds) and distance (in km) covered by a moving object,
calculate the speed in km/s and display the speed on the screen.
The relevant formula is: speed = distance/time.
*/

int main()
{
    float distance, time;
    printf("Enter distance (in km):");
    scanf("%f", &distance);
    printf("Enter time (in sec):");
    scanf("%f", &time);

    float speed = distance / time;
    printf("The speed is %.2f km/sec", speed);

    return 0;

}
