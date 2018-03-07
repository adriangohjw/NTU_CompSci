def method2():
    d = input('Enter date in the form of <ddmmyyyy>\n')
    month = {'01': 'Jan', '02': 'Feb', '03': 'Mar', '04': 'Apr', '05': 'May', '06': 'June',
             '07': 'Jul', '08': 'Aug', '09': 'Sep', '10': 'Oct', '11': 'Nov', '12': 'Dec'}
    print(d[0:2], month[d[2:4]], ',', d[4:])

while 1:
    method2()