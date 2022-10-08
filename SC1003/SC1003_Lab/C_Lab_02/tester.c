#include <stdio.h>
int main()
{
	/*edit*/
   /* Write your code here */

    int height;
    printf("Enter the height: \n");
    scanf("%d", &height);
    
    printf("The pattern is: \n");
    for (int i = 0; i < height; i++){
        printf("%d\n", i);
    }
    
    
	/*end_edit*/
   return 0;
}