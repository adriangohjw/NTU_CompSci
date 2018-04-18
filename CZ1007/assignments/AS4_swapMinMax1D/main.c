#include <stdio.h>

void swapMinMax1D(int ar[], int size);

int main()
{
    int ar[50],i,size;

    printf("Enter array size: \n");
    scanf("%d", &size);
    printf("Enter %d data: \n", size);
    for (i=0; i<size; i++)
        scanf("%d",ar+i);
    swapMinMax1D(ar, size);
    printf("swapMinMax1D(): ");
    for (i=0; i<size; i++)
        printf("%d ",*(ar+i));
    return 0;
}

void swapMinMax1D(int ar[], int size)
{
    /* takes in an array of integers ar and size (>1) as parameters
    finds the index positions of the largest number and smallest number in the array,
    swaps the index positions of these two numbers, and passes the array to the calling function via call by reference.
    If there are more than one largest or smallest number in the array,
    we will swap the last occurrence of the largest and smallest numbers */
    /* Write your code here */
    int index_max, index_min;

    if (ar[0] > ar[1]){
        index_max = 0;
        index_min = 1;
    } else {
        index_max = 1;
        index_min = 0;
    }

    for (int i=2; i<size; i++){
        if (ar[i] >= ar[index_max])
            index_max = i;
        if (ar[i] <= ar[index_min])
            index_min = i;
    }

    int temp = ar[index_max];
    ar[index_max] = ar[index_min];
    ar[index_min] = temp;
}
