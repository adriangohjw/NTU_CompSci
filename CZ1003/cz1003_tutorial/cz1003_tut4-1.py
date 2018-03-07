import sys

def main():
    rate_per_hour = 10
    
    try:
        # find gross pay
        num_hours = int(input("Number of hours:"))
        if num_hours < 0:
            raise ValueError
        elif num_hours > 160:
            rate_per_hour *= 1.5
        gross_pay = num_hours * rate_per_hour
        print("\tGross pay is ", gross_pay)

        # find taxes to be paid
        if gross_pay <= 1000:
            tax = .1 * gross_pay
        elif gross_pay <= 1500:
            tax = 100 + .2*(gross_pay-1000)
        else:
            tax = 200 + .3*(gross_pay-1500)
        print("\tTax amount is ", tax)

        # find net pay
        print("\tNet pay is ", gross_pay - tax)
        
    except ValueError:
        print("Error, please enter a positive whole number")

while 1:
    main()
