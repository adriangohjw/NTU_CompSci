#include <stdio.h>

int countWords(char *s);

int main()
{
    char str[50];
    printf("Enter the string: \n");
    gets(str);
    printf("countWords(): %d", countWords(str));
    return 0;
}

int countWords(char *s)
{
    /* Write your code here */
    int numWords = 0;

    int i = 0;
    while (s[i] != '\0'){
        if (s[i] != '\n'){
            if (s[i+1] == ' ' || s[i+1] == '\n' || s[i+1] == '\0'){
                numWords++;
            }
        }
        i++;
    }
    return numWords;
}
