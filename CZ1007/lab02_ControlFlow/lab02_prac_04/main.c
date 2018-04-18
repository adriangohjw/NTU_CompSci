#include <stdio.h>

/*
Write a C program that reads in character by character from an input source, until '#' is entered.
The output of the program is the number of English letters and the number of digits that appear in the input.
*/

int main()
{
    int ccount = 0, dcount = 0;
    char ch;
    printf("Enter your characters (# to end): \n");

    /* Write your program code here */
    scanf("%c", &ch);
    while (ch != '#'){
        if ('0' <= ch && ch <= '9')
            dcount++;
        else if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'))
            ccount++;
        scanf("%c", &ch);
    }

    printf("The number of digits: %d\n", dcount);
    printf("The number of letters: %d\n", ccount);
    return 0;
}
