#include <stdio.h>
#include <string.h>

void mergeStr(char *a, char *b, char *c);

int main()
{
    char a[80],b[80];
    char c[80];
    printf("Enter the first string: \n");
    gets(a);
    printf("Enter the second string: \n");
    gets(b);
    mergeStr(a,b,c);
    printf("mergeStr(): ");
    puts(c);
    return 0;
}

void mergeStr(char *a, char *b, char *c)
{
    /* Write your code here */
    int apos = 0, bpos = 0, cpos = 0;
    while (a[apos] != '\0' || b[bpos] != '\0'){
        if (a[apos] == '\0')
            c[cpos++] = b[bpos++];
        else if (b[bpos] == '\0')
            c[cpos++] = a[apos++];
        else if (a[apos] >= b[bpos])
            c[cpos++] = b[bpos++];
        else if (a[apos] < b[bpos])
            c[cpos++] = a[apos++];
    }
    c[cpos] = '\0';
}
