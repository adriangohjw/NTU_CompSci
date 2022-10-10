#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

int *temp_array;

int top_down_dp(int n)
{
    //write your code here
    if(n == 0){
        temp_array[0] = 0;
        return 0;
    }

    if(n == 1){
        temp_array[1] = 1;
        return 1;
    }

    if(n == 2){
        temp_array[2] = 2;
        return 2;
    }

    if(temp_array[n-1] == -1){
        temp_array[n-1] = top_down_dp(n-1);
    }

    if(temp_array[n-2] == -1){
        temp_array[n-2] = top_down_dp(n-2);
    }

    if(temp_array[n-3] == -1){
        temp_array[n-3] = top_down_dp(n-3);
    }

    temp_array[n] = temp_array[n-1] + (2 * temp_array[n-2]) - (3 * temp_array[n-3]);
    return temp_array[n];
}


 
int main ()
{
    int n;
    int function;
    int i;
    printf("Enter the value of n:\n");
    scanf("%d",&n);

    temp_array = malloc(sizeof(int) * (n+1));

    for(i = 0; i <= n; i++){
        temp_array[i] = -1;
    }
    
    printf("The value of F(%d) is: %d \n", n, top_down_dp(n));
        
}