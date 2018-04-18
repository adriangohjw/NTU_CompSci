#include <stdio.h>
#include <stdlib.h>

int countJumps(int ar[], int size);

int main()
{
    int rocks[20], count, size;
    printf("Enter number of rocks: ");
    scanf("%d", &size);
    for (count=0; count<size; count++)
        scanf("%d", &rocks[count]);
    printf("%d", countJumps(rocks, size));
    return 0;
}

int countJumps(int rocks[], int size){
    // 30 70 75 120 160 170 180 190 200 246 258
    int numJumps = 0, nextPos = 0, currentDist = 0;
    while (nextPos < size){
        if (rocks[nextPos] - currentDist > 50)
            return -1;
        else {
            int offset = 0; // internal counter
            while (rocks[nextPos+offset] - currentDist <= 50)
                offset++;
            currentDist = rocks[nextPos+offset-1];
            nextPos += offset;
            numJumps++;
        }
    }
    return numJumps;
}
