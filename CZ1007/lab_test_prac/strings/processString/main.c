#include <stdio.h>

void processString(char *str, int *totVowels, int *totDigits);

int main()
{
    char str[50];
    int totVowels, totDigits;
    printf("Enter the string: \n");
    gets(str);
    processString(str, &totVowels, &totDigits);
    printf("Total vowels = %d\n", totVowels);
    printf("Total digits = %d\n", totDigits);
    return 0;
}

void processString(char *str, int *totVowels, int *totDigits)
{
    /* Write your program code here */
    *totVowels = 0;
    *totDigits = 0;
    int count;
    char vowels[10] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    int i = 0;
    while (str[i] != '\0'){
        if (str[i] >= '0' && str[i] <= '9'){
            (*totDigits)++;
        } else {
            for (count=0; count<10; count++){
                if (str[i] == vowels[count]){
                    (*totVowels)++;
                }
            }
        }
        i++;
    }
}
