	/*edit*/

/*custom header*/

	/*end_edit*/
#include <stdio.h>
int main()
{
	/*edit*/
   /* Write your code here */
    int category, coe;
    double list_Price;
    
    printf("Please enter the list price: \n");
    scanf("%lf",&list_Price);
    
    printf("Please enter the category: \n");
    scanf("%d",&category);
    
    list_Price *= 0.9;
    
    if (list_Price >= 100000){
        list_Price *= 1.13;
    }
    else{
       list_Price *= 1.03;
    }
    
    switch(category){
        case 1: {
            coe = 70000;
            break;
        }
        case 2: {
            coe = 80000;
            break;
        }
        case 3: {
            coe = 23000;
            break;
        }
        case 4: {
            coe = 600;
            break;
        }
    }
    printf("Total price is %.2f\n", ((list_Price+coe)));
	/*end_edit*/
   return 0;  
}