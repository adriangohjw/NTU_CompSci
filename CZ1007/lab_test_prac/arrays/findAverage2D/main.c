#include <stdio.h>

void findAverage2D(float matrix[4][4]);

int main()
{
    float ar[4][4];
    int i,j;

    printf("Enter data: \n");
    for (i = 0; i < 4; i++) {
        for (j = 0; j < 4; j++)
            scanf("%f", &ar[i][j]);
    }
    findAverage2D(ar);
    printf("findAverage2D(): :\n");
    for (i = 0; i < 4; i++) {
        for (j = 0; j < 4; j++)
            printf("%.2f ", ar[i][j]);
        printf("\n");
    }
    return 0;
}

void findAverage2D(float matrix[4][4])
{
    /* write your program code here */
    int row, col;
    for (row=0; row<4; row++){
        matrix[row][3] = 0;
        for (col=0; col<3; col++){
            matrix[row][3] += matrix[row][col];
        }
        matrix[row][3] = matrix[row][3] / 3;
    }
}
