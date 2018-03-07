#include <stdio.h>
#include <stdlib.h>

/* takes a 5x5 2-dimensional array of integers a as a parameter,
Returns the maximum and minimum numbers of the array back */

void minmax(int ar[5][5], int *min, int *max);

int main()
{
    int array_to_pass[5][5] = {
        {5, 10, 15, 20, 25},
        {10, 15, 20, 25, 30},
        {15, 20, 25, 30, 35},
        {20, 25, 30, 35, 40},
        {25, 30, 35, 40, 45}
    };

    int min, max;
    minmax(array_to_pass, &min, &max);
    printf("The minimum number is %d and the maximum is %d", min, max);
    return 0;
}

void minmax(int ar[5][5], int *min, int *max){
    /* using pointer */
    *min = ar[0][0];
    *max = ar[0][0];
    for (int i=0; i<5; i++){
        for (int j=0; j<5; j++){
            if (ar[i][j] < *min)
                *min = ar[i][j];
            if (ar[i][j] > *max)
                *max = ar[i][j];
        }
    }
}

