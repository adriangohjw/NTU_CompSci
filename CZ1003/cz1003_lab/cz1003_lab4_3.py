from datetime import datetime


def main():
    d = input('Enter date in the form of <dd/mm/yyyy>\n')
    d = datetime.strptime(d, '%d/%m/%Y')
    print(d.strftime('%b %d,%Y'))
    print()


def method2():
    d = input('Enter date in the form of <dd/mm/yyyy>\n').replace('/', ' ').split()
    month = {'01': 'Jan', '02': 'Feb', '03': 'Mar', '04': 'Apr', '05': 'May', '06': 'June',
             '07': 'Jul', '08': 'Aug', '09': 'Sep', '10': 'Oct', '11': 'Nov', '12': 'Dec'}
    print(d[0], month[d[1]], ',', d[2])

while 1:
    method2()