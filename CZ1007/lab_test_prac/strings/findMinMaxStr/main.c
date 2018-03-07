#include <stdio.h>
#include <string.h>
#define SIZE 10

void findMinMaxStr(char word[][40], char *first, char *last, int size);

int main()
{
    char word[SIZE][40];
    char first[40], last[40];
    int i, size;

    printf("Enter size: \n");
    scanf("%d", &size);
    printf("Enter %d words: \n", size);
    for (i=0; i<size; i++)
        scanf("%s", word[i]);
    findMinMaxStr(word, first, last, size);
    printf("First word = %s, Last word = %s\n", first, last);
    return 0;
}

void findMinMaxStr(char word[][40], char *first, char *last, int size)
{
    /* Write your program code here */
    strcpy(first, word[0]);
    strcpy(last, word[0]);

    int i, j;
    for (i=1; i<size; i++){

        j = 0;
        while (first[j] != '\0' && word[i][j] != '\0'){
            if (first[j] == word[i][j]){
                j++;
            } else if (first[j] > word[i][j]){
                strcpy(first, word[i]);
                break;
            } else {
                break;
            }
        }

        j = 0;
        while (last[j] != '\0' && word[i][j] != '\0'){
            if (first[j] == word[i][j]){
                j++;
            } else if (last[j] < word[i][j]){
                strcpy(last, word[i]);
                break;
            } else {
                break;
            }
        }
    }
}
