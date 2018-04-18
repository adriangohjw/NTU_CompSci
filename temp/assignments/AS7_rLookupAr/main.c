#include <stdio.h>

/* recursive function takes in three parameters (array, size and target),
returns the subscript of the last appearance of a number in the array */

int rLookupAr(int array[], int size, int target);

int main()
{
    int numArray[80];
    int target, i, size;

    printf("Enter array size: \n");
    scanf("%d", &size);
    printf("Enter %d numbers: \n", size);
    for (i=0; i < size; i++)
        scanf("%d", &numArray[i]);
    printf("Enter the target number: \n");
    scanf("%d", &target);
    printf("rLookupAr(): %d", rLookupAr(numArray, size, target));
    return 0;
}

int rLookupAr(int array[], int size, int target)
{
    /* Write your code here */
    if (array[size-1] == target){
        return size-1;
    } else {
        return rLookupAr(array, size-1, target);
    }
}
