#include <stdio.h>
//  not allowed to use any functions from the C standard String library.

/*
Write a C function stringncpy() that
copies not more than n characters (characters that follow a null character are not copied)
from the array pointed to by s2 to the array pointed to by s1.
If the array pointed to by s2 is a string shorter than n characters, null characters are appended to the copy
in the array pointed to by s1, until n characters in all have been written.
The stringncpy() returns the value of s1.
*/

char *stringncpy(char *s1, char *s2, int n);

int main(){
    char sourceStr[40], targetStr[40], *target;
    int length;
    printf("Enter the string: \n");
    gets(sourceStr);
    printf("Enter the number of characters: \n");
    scanf("%d", &length);
    target = stringncpy(targetStr, sourceStr, length);
    printf("stringncpy(): %s\n", target);
    return 0;
}

char *stringncpy(char *s1, char *s2, int n) {
    /* Write your program code here */
    int length = 0, i = 0;
    while (*(s2+i)!='\0'){
        length++;
        i++;
    }
    if (length < n){
        for (int j=0; j < n; j++){
            if (j < length)
                *(s1+j) = *(s2+j);
            else
                *(s1+j) = '\0';
        }
    } else {
        for (int j=0; j < n; j++)
            *(s1+j) = *(s2+j);
    }
    *(s1+n) = '\0';  /* very important! tell compiler that this is the end of the string */
    return s1;
}
