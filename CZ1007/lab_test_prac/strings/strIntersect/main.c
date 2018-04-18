#include <stdio.h>

void strIntersect(char *str1, char *str2, char *str3);

int main()
{
    char str1[50],str2[50],str3[50];

    printf("Enter str1: \n");
    scanf("%s",str1);
    printf("Enter str2: \n");
    scanf("%s",str2);
    strIntersect(str1, str2, str3);
    if (*str3 == '\0')
        printf("strIntersect(): null string\n");
    else
        printf("strIntersect(): %s\n", str3);
    return 0;
}

void strIntersect(char *str1, char *str2, char *str3)
{
    /* Write your code here */
    int i = 0, j = 0, pos = 0;
    while (str1[i] != '\0'){
        j = 0;
        while (str2[j] != '\0'){
            if (str1[i] == str2[j])
                str3[pos++] = str1[i];
            j++;
        }
        i++;
    }
    str3[pos] = '\0';
}
