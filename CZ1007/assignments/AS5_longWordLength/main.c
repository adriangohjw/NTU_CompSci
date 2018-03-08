#include <stdio.h>

/* accepts an English sentence as parameter, and returns the length of the longest word in the sentence */

int longWordLength(char *s);
int main()

{
    char str[80];
    printf("Enter a string: \n");
    gets(str);
    printf("longWordLength(): %d\n", longWordLength(str));
    return 0;
}

int longWordLength(char *s)
{
    /* Write your code here */
    int i = 0, len_longest = 0, count = 0;
    while (s[i] != '\0'){
        if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')){
            count++;  // count if is letter
        } else {
            if (len_longest < count){
                len_longest = count;
            }
            count = 0;  // reset strlen count to 0
        }
        i++;
    }
    if (len_longest < count)
        len_longest = count;
    return len_longest;
}
