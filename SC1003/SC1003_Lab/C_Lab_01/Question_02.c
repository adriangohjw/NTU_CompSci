#include <stdio.h>
int main()
{
    // varialbes for first loop
    int number_Of_Lines;
    //variables for per line
    int line_Input;
    double number_Of_Items, total, average;

    printf("Enter number of lines: \n");
    scanf("%d", &number_Of_Lines);
    
    for (int i = 1; i < (number_Of_Lines + 1); i++) {
        
        printf("Enter line %d (end with -1): \n", i);
        scanf("%d", &line_Input);

        while (line_Input != -1) {
            total += line_Input;
            number_Of_Items++;
            scanf("%d", &line_Input);
        }
        average = total / number_Of_Items;
        printf("Average = %.2f\n", average);
    }
    return 0;
}