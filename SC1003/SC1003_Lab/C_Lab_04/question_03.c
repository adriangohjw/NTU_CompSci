#include <stdio.h>
#include <string.h>
#define INIT_VALUE -1000
int palindrome(char *str);

int main()
{
    char str[80], *p;
    int result = INIT_VALUE;

    printf("Enter a string: \n");
    fgets(str, 80, stdin);

    if (p=strchr(str,'\n')) *p = '\0';

    result = palindrome(str);
    
    if (result == 1){
        printf("palindrome(): A palindrome\n");
    }
    else if (result == 0){
        printf("palindrome(): Not a palindrome\n");
    }
    else{
        printf("An error\n");
    }

    return 0;
}

int palindrome(char *str){
    /* Write your code here */
    for (int i = 0; i < strlen(str); i++){
        if(i < strlen(str) - i){
            if ( *(str+i) != *(str + (strlen(str) - 1 - i)) ){
                return 0;
            }
        }

    }
    return 1;
}