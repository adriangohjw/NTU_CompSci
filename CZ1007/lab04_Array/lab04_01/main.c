#include <stdio.h>
void printReverse1(int ar[], int size);
void printReverse2(int ar[], int size);
void reverseAr1D(int ar[], int size);

int main()
{
    int ar[10];
    int size, i;

    printf("Enter array size: \n");
    scanf("%d", &size);

    printf("Enter %d data: \n", size);
    for (i=0; i <= size-1; i++)
        scanf("%d", &ar[i]);
    printReverse1(ar, size);
    printReverse2(ar, size);

    reverseAr1D(ar, size);
    printf("reverseAr1D(): ");
    if (size > 0) {
        for (i=0; i<size; i++)
            printf("%d ", ar[i]);
    }
    return 0;
}

void printReverse1(int ar[], int size)
{
    /* using index - Write your program code here */
    /* prints an array of integers in reverse order */
    printf("printReverse1(): ");
    for (int i=size-1; i >= 0; i--){
        printf("%d ", ar[i]);
    }
    printf("\n");
}

void printReverse2(int ar[], int size)
{
    /* using pointer - Write your program code here */
    /* prints an array of integers in reverse order */
    printf("printReverse2(): ");
    for (int i=size-1; i >= 0; i--){
        int *pInt = &ar[i];
        printf("%d ", *pInt);
    }
    printf("\n");
}

void reverseAr1D(int ar[], int size)
{
    /* Write your program code here */
    /* converts the content in the array in reverse order
    and passes the array to the calling function via call by reference */
    for (int i=0; i < size/2; i++){
        int temp = ar[i];
        ar[i] = ar[size-(1+i)];
        ar[size-(1+i)] = temp;
    }
}
