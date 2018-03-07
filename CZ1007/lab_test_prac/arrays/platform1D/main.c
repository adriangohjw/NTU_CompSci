#include <stdio.h>

int platform1D(int ar[], int size);

int main()
{
    int i,b[50],size;
    printf("Enter array size: \n");
    scanf("%d", &size);
    printf("Enter %d data: \n", size);
    for (i=0; i<size; i++)
        scanf("%d",&b[i]);
    printf("platform1D(): %d\n", platform1D(b,size));
    return 0;
}

int platform1D(int ar[], int size)
{
    /* Write your program code here */
    int pos, length_max = 1, length = 1;
    for (pos=1; pos<size; pos++){
        if (ar[pos] == ar[pos-1]){
            length++;
        } else {
            if (length_max < length) {
                length_max = length;
            }
            length = 1;
        }
    }
    return length_max;
}
