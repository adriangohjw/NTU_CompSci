#include <stdio.h>
#define SIZE 10

int minOfMax2D(int ar[][SIZE], int rowSize, int colSize);

int main()
{
    int ar[SIZE][SIZE], rowSize, colSize;
    int i,j,min;

    printf("Enter row size of the 2D array: \n");
    scanf("%d", &rowSize);
    printf("Enter column size of the 2D array: \n");
    scanf("%d", &colSize);
    printf("Enter the matrix (%dx%d): \n", rowSize, colSize);
    for (i=0; i<rowSize; i++)
        for (j=0; j<colSize; j++)
            scanf("%d", &ar[i][j]);
    min=minOfMax2D(ar, rowSize, colSize);
    printf("minOfMax2D(): %d\n", min);
    return 0;
}

int minOfMax2D(int ar[][SIZE], int rowSize, int colSize)
{
    /* Write your program code here */
    int row, col;
    int rowMax;

    int minOfMax = ar[0][0];
    for (col=1; col<colSize; col++){
        if (ar[0][col] > minOfMax){
            minOfMax = ar[0][col];
        }
    }

    for (row=1; row<rowSize; row++){
        rowMax = ar[row][0];
        for (col=1; col<colSize; col++){
            if (ar[row][col] > rowMax){
                rowMax = ar[row][col];
            }
        }
        if (rowMax < minOfMax){
            minOfMax = rowMax;
        }
    }
    return minOfMax;
}
