#include <stdio.h>

int rStrLen(char *s);

int main()
{
    char str[80];
    printf("Enter the string: \n");
    gets(str);
    printf("rStrLen(): %d\n", rStrLen(str));
    return 0;
}

int rStrLen(char *s)
{
    /* Write your program code here */
    if (*s == '\0')
        return 0;
    else {
        return 1 + rStrLen(s+1);
    }
}
