#include <stdio.h>

/*  Write a program to calculate the actual cost of buying a car in Singapore.
Your program should input the list price and the category of a car, and print out the actual cost.
Based on the list price, assuming that the car dealer will give a discount of 10%.
You should also consider that there is a 10% luxury tax on the amount over $100,000 (after the discount),
and that the G.S.T. tax is 3%.

All taxes are computed based on the discounted price.
Certificate of Entitlement (COE) must be obtained for every car in Singapore.
The amount you bid for the COE is based on the category your car belongs to.
COE is not taxed.
The categories and their COE prices are given below:
    (1) Car (1600 c.c. & below) & Taxi: COE = 70,000
    (2) Car (above 1600 c.c.): COE = 80,000
    (3) Goods Vehicle & Bus: COE = 23,000
    (4) Motorcycle - COE: 600
*/

int main()
{
    int list, coe = 0, cat;
    double discounted, luxury = 0, gst, total;

    printf("Please enter the list price: \n");
    scanf("%d", &list);
    printf("Please enter the category: \n");
    scanf("%d", &cat);

    /* Write your program code here */
    discounted = 0.9 * (double)list;
    gst = 0.03 * discounted;

    if (100000 < discounted)
        luxury = (discounted - 100000) * 0.1;

    switch (cat) {
        case 1:
            coe = 70000;
            break;
        case 2:
            coe = 80000;
            break;
        case 3:
            coe = 23000;
            break;
        case 4:
            coe = 600;
            break;
    }

    total = discounted + gst + luxury + coe;

    printf("Total price is $%.2f\n", total);
    return 0;
}
