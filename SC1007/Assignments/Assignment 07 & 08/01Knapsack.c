#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

int **temp_array;

int bottom_up_dp(int n, int *s, int *v, int C)
{
    //write your code here
    int i;
    int j;
 
    if(n == 0 || C == 0){
        return 0;
    }

    for(i = 1; i <= n; i++){
        for(j = 1; j <= C; j++){
            if(s[i] <= j){
                if(temp_array[i-1][j] >= temp_array[i-1][j-s[i]] + v[i]){
                    temp_array[i][j] = temp_array[i-1][j];
                }
                else{
                    temp_array[i][j] = temp_array[i-1][j-s[i]] + v[i];
                }
            }
            else{
                temp_array[i][j] = temp_array[i-1][j];
            }
        }
    }

    for(i = 1; i <= n; i++){
        for(j = 1; j <= C; j++){
            printf("%d ", temp_array[i][j]);
        }
        printf("\n");
    }


    return temp_array[n][C];
    
}

 
int main ()
{
    int n,C;
    int function;
    int *s;
    int *v;
    int i,j;
    printf("Enter the number of items n:\n");
    scanf("%d",&n);
    printf("Enter the capacity C:\n");
    scanf("%d",&C);
    s = (int *) malloc(sizeof(int) * (n+1));
    v = (int *) malloc(sizeof(int) * (n+1));
    
    temp_array = (int **)malloc(sizeof(int *) * (n+1));
    for(i = 0; i <= n; i++){
        temp_array[i] = (int *)malloc(sizeof(int) * (C+1));
    }

    for(i = 0; i <= n; i++){
        for(j = 0; j <= C; j++)
        temp_array[i][j] = 0;
    }

    printf("Enter the sizes of items (as a list, separate by spacing:\n");
    for (i=1;i<=n;i++)
        scanf("%d",&s[i]);
        
    printf("Enter the values of items (as a list, separate by spacing:\n");
    for (i=1;i<=n;i++)
        scanf("%d",&v[i]);
    
    printf("The maximum value is: %d \n", bottom_up_dp(n,s,v,C));
        
}