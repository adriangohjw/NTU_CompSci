#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

int **temp_array;

int max(int a, int b){
    if(a >= b){
        return a;
    }
    else{
        return b;
    }
}

int top_down(int n, int *s, int *v, int C)
{
    //write your code here
    int i;
    int j;
 
    if(n == 0 || C == 0){
        return 0;
    }

    temp_array[0][0] = 0;

    if(temp_array[n][C] != 0){
        return temp_array[n][C];
    }
    for(i = 1; i <= n; i++){
        int row = n - i;
        for(j = 1; j <= C; j++){
            int col = C - j;
            temp_array[n][C] = max(temp_array[row][col], top_down(row, s, v, col)+v[row]);
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
    
    printf("The maximum value is: %d \n", top_down(n,s,v,C));
        
}