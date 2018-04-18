#include <stdio.h>

int countSubstring(char str[], char substr[]);

int main()
{
    char str[80],substr[80];

    printf("Enter the string: \n");
    gets(str);
    printf("Enter the substring: \n");
    gets(substr);
    printf("countSubstring(): %d\n", countSubstring(str, substr));
    return 0;
}

int countSubstring(char str[], char substr[])
{
    /* Write your code here */
    int substrlen = 0;
    while (substr[substrlen] != '\0'){
        substrlen++;
    }

    int count = 0;
    int i, strpos = 0, result = 1;
    while (str[strpos] != '\0'){
        result = 1;
        for (i=0; i<substrlen; i++){
            if (str[strpos+i] != substr[i])
                result = 0;
        }
        if (result == 1)
            count++;
        strpos++;
    }
    return count;
}
