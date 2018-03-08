#include <stdio.h>

/* takes in a string str1 as an argument and copies the contents of character string str1 into character string str2.
For every three char copied from str1 to str2, the char ch is inserted into str2.
The function returns the resultant string to the calling function via call by reference. */

void insertChar(char *str1, char *str2, char ch);

int main()
{
    char a[80],b[80];
    char ch;

    printf("Enter a string: \n");
    gets(a);
    printf("Enter a character to be inserted: \n");
    ch = getchar();
    insertChar(a,b,ch);
    printf("insertChar(): ");
    puts(b);
    return 0;
}

void insertChar(char *str1, char *str2, char ch)
{
    /* Write your code here */
    int i = 0, str2pos = 0, count = 0;
    while (str1[i] != '\0' || count == 3){
        if (count == 3){
            str2[str2pos] = ch;
            count = 0;
        } else {
            str2[str2pos] = str1[i];
            i++;
            count++;
        }
        str2pos++;
    }
    str2[str2pos] = '\0';
}
