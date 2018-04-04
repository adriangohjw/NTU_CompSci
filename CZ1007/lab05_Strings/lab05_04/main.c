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
    int length = 0;
    while (*(str+length) != '\0')
        length++;

    int pos;
    for(pos=0; pos<length/2; pos++){
        if (*(str+pos) != *(str+length-1-pos))
            return 0;
    }
    return 1;
}
