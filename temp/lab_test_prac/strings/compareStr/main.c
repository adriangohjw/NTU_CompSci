#include <stdio.h>

int compareStr(char *s, char *t);

int main()
{
    char a[80],b[80];
    printf("Enter the first string: \n");
    gets(a);
    printf("Enter the second string: \n");
    gets(b);
    printf("compareStr(): %d\n", compareStr(a,b));
    return 0;
}

int compareStr(char *s, char *t)
{
    /* Write your code here */
    int i=0;

    // check char by char (for str with same length)
    while (s[i] != '\0' && t[i] != '\0') {
        if (s[i] == t[i])
            i++;
        else
            return s[i] - t[i];
    };

    // if one string longer than another
    return s[i] - t[i];
}
