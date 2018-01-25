#include <stdio.h>
#define INIT_VALUE -1

int palindrome(char *str);

int main() {
    char str[80];
    int result = INIT_VALUE;  // -1

    printf("Enter a string: \n");
    gets(str);
    result = palindrome(str);
    if (result == 1)
        printf("palindrome(): A palindrome\n");
    else if (result == 0)
        printf("palindrome(): Not a palindrome\n");
    else
        printf("An error\n");
    return 0;
}

int palindrome(char *str){
    /* palindrome is a sequence of characters that reads the same forwards and backwards */
    /* return 1 if positive, else 0 */
    /* Write your code here */
    int length = 0, i = 0;
    while (str[i] != '\0'){
        length++;
        i++;
    }
    int to_return = 1;
    for (int j=0; j < length/2; j++){
        if (str[j] != str[(length-1)-j]){
            to_return = 0;
            break;
        }
    }
    return to_return;
}
