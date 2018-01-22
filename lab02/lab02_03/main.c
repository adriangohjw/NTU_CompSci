#include <stdio.h>
#include <stdlib.h>

int main()
{
    int height;
    printf("Enter the height:\n");  // accept from 1 to 10
    scanf("%d", &height);

    printf("Pattern: \n");
    for (int row=1; row<=height; row++){

        int to_print;
        if (row % 3 == 0)
            to_print = 3;
        else if (row % 3 == 2)
            to_print = 2;
        else
            to_print = 1;

        for (int count=1; count<=row; count++){
            printf("%d", to_print);
        }
        printf("\n");
    }

    return 0;
}
