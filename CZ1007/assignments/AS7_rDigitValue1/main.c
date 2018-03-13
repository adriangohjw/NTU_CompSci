#include <stdio.h>

/* recursive function that returns the value of the kth digit (k>0) from the right of a non-negative integer num.
For example, if num=1234567 and k=3, the function will return 5 and if num=1234 and k=8, the function will return 0. */

int rDigitValue1(int num, int k);

int main()
{
    int k, number;
    printf("Enter a number: \n");
    scanf("%d", &number);
    printf("Enter k position: \n");
    scanf("%d", &k);
    printf("rDigitValue1(): %d\n", rDigitValue1(number, k));
    return 0;
}

int rDigitValue1(int num, int k)
{
    /* Write your code here */
   if (k==0)
      return 0;
   else if (k==1)
      return num%10;
   else
      return rDigitValue1(num/10, k-1);
}
