#include <stdio.h>
int main()
{
    int height;
    int num = 0;

    while (!(height >= 1 && height <= 10)) {
        printf("Enter the height: \n");
        scanf("%d", &height);
    }

    printf("Pattern: \n");
    for (int i = 1; i < (height+1); i++) {
        for (int j = 1; j < (i+1); j++) {
            printf("%d", num+1);
            /*
            switch(i%3){
                case 1: {
                    printf("%d", 1);
                    break;
                }
                case 2: {
                    printf("%d", 2);
                    break;
                }
                case 0: {
                    printf("%d", 3);
                    break;
                }
            }
            */
        }
        num = i % 3;
        printf("\n");

    }
    return 0;
}