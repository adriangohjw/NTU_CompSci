#include <stdio.h>
#define INIT_VALUE 999

/*  compares the string pointed to by s1 to the string pointed to by s2
If s1 is greater than, equal to, or less than s2, then it returns 1, 0 or –1 respectively. */

int stringcmp(char *s1, char *s2);

int main()
{
    char source[80], target[80];
    int result = INIT_VALUE;

    printf("Enter a source string: \n");
    gets(source);
    printf("Enter a target string: \n");
    gets(target);
    result = stringcmp(source, target);
    if (result == 1)
        printf("stringcmp(): greater than");
    else if (result == 0)
        printf("stringcmp(): equal");
    else if (result == -1)
        printf("stringcmp(): less than");
    else
        printf("stringcmp(): error");
    return 0;
}

int stringcmp(char *s1, char *s2)
{
    /* Write your code here */
    int i = 0;
    while (s1[i]!='\0' || s2[i]!='\0'){
        if (s1[i] > s2[i])
            return 1;
        else if (s1[i] < s2[i])
            return -1;
        else
            i++;
    }
    return 0;
}
