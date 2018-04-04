#include <stdio.h>
#include <stdlib.h>

void insert(char *str, int size);
void removes(char *str, int size);

int main()
{
    int num_char;
    printf("How many characters do you want to input: ");
    scanf("%d", &num_char);

    char *userstr = malloc(num_char+1);
    printf("Input the string:");
    scanf("%s", userstr);

    printf("The string is: %s\n", userstr);

    int choice;
    do {
        printf("Do you want to 1-insert or 2-remove or 3-quit?: ");
        scanf("%d", &choice);
        switch (choice){
            case 1:
                insert(userstr, num_char);
                printf("Resulting string: %s\n", userstr);
                break;
            case 2:
                removes(userstr, num_char);
                printf("Resulting string: %s\n", userstr);
                break;
            default:
                break;
        }
    } while (choice != 3);

    return 0;
}

void insert(char *str, int size){
    char char_to_insert;
    printf("What is the character you want to insert: ");
    scanf(" %c", &char_to_insert);

    int count;
    for(count=size-1; count!=0; count--)
        *(str+count) = *(str+count-1);
    *(str+0) = char_to_insert;
}

void removes(char *str, int size){
    int count;
    for(count=0; count<(size-1); count++)
        *(str+count) = *(str+count+1);
    *(str+(size-1)) = '\0';
}
