#include <stdio.h>
typedef struct {
    char source;
    char code;
} Rule;

void encodeChar(Rule table[5], char *s, char *t);

int main()
{
    char s[80],t[80];
    Rule table[5] = {'a','d', 'b','z', 'z','a', 'd','b', '\0','\0' };

    printf("Source string: \n");
    gets(s);
    encodeChar(table,s,t);
    printf("Encoded string: %s\n", t);
    return 0;
}

void encodeChar(Rule table[5], char *s, char *t)
{
    /* Write your program code here */
    int i, pos=0;
    while (s[pos] != '\0'){
        for (i=0; i<5; i++){
            if (s[pos] != table[i].source)
                t[pos] = s[pos];
            else {
                t[pos] = table[i].code;
                break;
            }
        }
        pos++;
    }
    t[pos] = '\0';
}
