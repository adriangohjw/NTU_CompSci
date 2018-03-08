#include <stdio.h>

/* accepts string str, finds the largest character and moves it to the beginning of the string
If more than one largest character is in the string, then first appearance of it will be moved */

void maxCharToFront(char *str);

int main()
{
    char str[80];

    printf("Enter a string: \n");
    gets(str);
    printf("maxCharToFront(): ");
    maxCharToFront(str);
    puts(str);
    return 0;
}

void maxCharToFront(char *str)
{
    /* Write your code here */
    int i = 0, index_largest = 0;
    char largest_ch = str[i];
    while (str[i] != '\0'){
        if (str[i] > largest_ch){
            largest_ch = str[i];
            index_largest = i;
        }
        i++;
    }
    for (int count = index_largest; count != 0; count--){
        str[count] = str[count-1];
    }
    str[0] = largest_ch;
}
