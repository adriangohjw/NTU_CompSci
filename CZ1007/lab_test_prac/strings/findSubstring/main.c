#include <stdio.h>
#define INIT_VALUE -1

int findSubstring(char *str, char *substr);

int main()
{
    char str[40], substr[40];
    int result = INIT_VALUE;
    printf("Enter the string: \n");
    gets(str);
    printf("Enter the substring: \n");
    gets(substr);
    result = findSubstring(str, substr);
    if (result == 1)
        printf("findSubstring(): Is a substring\n");
    else if ( result == 0)
        printf("findSubstring(): Not a substring\n");
    else
        printf("findSubstring(): An error\n");
    return 0;
}

int findSubstring(char *str, char *substr)
{
    /* Write your code here */
    int substrlen = 0;
    while (substr[substrlen] != '\0'){
        substrlen++;
    }

    int i, strpos = 0, result = 1;
    while (str[strpos] != '\0'){
        for (i=0; i<substrlen; i++){
            if (str[strpos+i] != substr[i])
                result = 0;
        }
        if (result == 1)
            return result;
        else
            strpos++;
    }
    return result;
}
