#include <stdio.h>
#include <string.h>
#define MAX 100

typedef struct {
    char name[20];
    char telno[20];
} PhoneBk;

int readin(PhoneBk *p);
void search(PhoneBk *p, int size, char *target);

int main()
{
    PhoneBk s[MAX];
    char t[20];
    int size;
    size = readin(s);
    printf("Enter search name: \n");
    gets(t);
    search(s,size,t);
    return 0;
}

int readin(PhoneBk *p)
{
    /* Write your program code here */
    int count = 0;
    while (1) {
        printf("Enter name:\n");
        scanf("\n");
        gets(p[count].name);
        if (strcmp((p[count].name), "#")==0){
            break;
        } else {
            printf("Enter tel:\n");
            scanf("\n");
            gets(p[count].telno);
            count++;
        }
    }
    return count;
}

void search(PhoneBk *p, int size, char *target)
{
    /* Write your program code here */
    int pos;
    for (pos=0; pos<size; pos++){
        if (strcmp(p[pos].name, target)==0){
            printf("Name = %s, Tel = %s\n", p[pos].name, p[pos].telno);
            return;
        }
    }
    printf("Name not found!\n");
}
