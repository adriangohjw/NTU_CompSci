#include <stdio.h>
#include <string.h>
#include <ctype.h>

void cipher(char *s);
void decipher(char *s);

int main()
{
    char str[80];

    printf("Enter the string: \n");
    gets(str);
    printf("To cipher: %s -> ", str);
    cipher(str);
    printf("%s\n", str);
    printf("To decipher: %s -> ", str);
    decipher(str);
    printf("%s\n", str);
    return 0;
}

void cipher(char *s)
{
    /* Write your program code here */
    int i = 0;
    while (s[i] != '\0'){
        if (s[i] == 'z')
            s[i] = 'a';
        else if (s[i] == 'Z')
            s[i] = 'A';
        else if ((s[i] < '0' || s[i] > '9') && s[i] != ' ')
            s[i] += 1;
        i++;
    }
}

void decipher(char *s)
{
    /* Write your program code here */
    int i = 0;
    while (s[i] != '\0'){
        if (s[i] == 'a')
            s[i] = 'z';
        else if (s[i] == 'A')
            s[i] = 'Z';
        else if ((s[i] < '0' || s[i] > '9') && s[i] != ' ')
            s[i] -= 1;
        i++;
    }
}
