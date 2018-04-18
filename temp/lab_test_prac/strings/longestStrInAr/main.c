#include <stdio.h>
#include <string.h>
#define N 20

char *longestStrInAr(char str[N][40], int size, int *length);

int main()
{
    int i, size, length;
    char str[N][40], first[40], last[40], *p;
    char dummychar;

    printf("Enter array size: \n");
    scanf("%d", &size);
    scanf("%c", &dummychar);
    for (i=0; i<size; i++) {
        printf("Enter string %d: \n", i+1);
        gets(str[i]);
    }
    p = longestStrInAr(str, size, &length);
    printf("longest: %s \nlength: %d\n", p, length);
    return 0;
}

char *longestStrInAr(char str[N][40], int size, int *length)
{
    /* Write your code here */
    *length = 0;
    char longest[40];
    strcpy(longest, str[0]);

    int wordpos, charpos;
    for (wordpos=0; wordpos<size; wordpos++){
        charpos = 0;
        while (str[wordpos][charpos] != '\0'){
            charpos++;
        }
        if (charpos > *length){
            *length = charpos;
            strcpy(longest, str[wordpos]);
        }
    }

    return longest;
}
