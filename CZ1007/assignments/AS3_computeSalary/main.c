#include <stdio.h>
void readInput(int *id, int *noOfHours, int *payRate);
void printOutputs(int id, double grossPay);
double computeSalary1(int noOfHours, int payRate);
void computeSalary2(int noOfHours, int payRate, double *grossPay);

int main()
{
    int id = -1, noOfHours, payRate;
    double grossPay;

    readInput(&id, &noOfHours, &payRate);
    while  (id != -1) {
      printf("computeSalary1(): ");
      grossPay = computeSalary1(noOfHours, payRate);
      printOutputs(id, grossPay);
      printf("computeSalary2(): ");
      computeSalary2(noOfHours, payRate, &grossPay);
      printOutputs(id, grossPay);
      readInput(&id, &noOfHours, &payRate);
    }
    return 0;
}

void readInput(int *id, int *noOfHours, int *payRate)
{
    /* Write your program code here */
    printf("Enter ID (-1 to end):\n");
    scanf("%d", id);
    if (*id == -1){
        return ;
    } else {
        printf("Enter number of hours:\n");
        scanf("%d", noOfHours);
        printf("Enter hourly pay rate:\n");
        scanf("%d", payRate);
    }
}

void printOutputs(int id, double grossPay)
{
    /* Write your program code here */
    printf("ID %d grossPay %.2f\n", id, grossPay);
}

double computeSalary1(int noOfHours, int payRate)
{
    /* Write your program code here */
    int grossPay;
    if (noOfHours <= 160){
        grossPay = noOfHours * payRate;
    } else {
        grossPay = 160 * payRate + (noOfHours - 160) * payRate * 1.5;
    }
    return grossPay;
}

void computeSalary2(int noOfHours, int payRate, double *grossPay)
{
    /* Write your program code here */
        /* Write your program code here */
    if (noOfHours <= 160){
        *grossPay = noOfHours * payRate;
    } else {
        *grossPay = 160 * payRate + (noOfHours - 160) * payRate * 1.5;
    }
}
