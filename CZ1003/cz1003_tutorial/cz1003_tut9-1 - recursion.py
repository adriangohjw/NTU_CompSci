from random import randint


def maxInList(aList):  # recursion method
    print(aList)  # print list for sanity check
    if len(aList) == 1:  # if left one element in the list, end function and return number
        return aList[0]
    else:
        # if 1st number > 2nd number, remove 2nd number and repeat
        if aList[0] > aList[1]:
            del aList[1]
            return maxInList(aList)
        # if 1st number < 2nd number, remove 2nd number and repeat
        else:
            del aList[0]
            return maxInList(aList)

# generate list with 20 elements, each randomly generated from 0 to 99
my_list = [randint(0, 100) for i in range(0, 20)]
print('starting maxInList function...')
print(maxInList(my_list))
print()


def minInList(aList):  # recursion method
    print(aList)  # print list for sanity check
    if len(aList) == 1:  # if left one element in the list, end function and return number
        return aList[0]
    else:
        # if 1st number > 2nd number, remove 1st number and repeat
        if aList[0] > aList[1]:
            del aList[0]
            return minInList(aList)
        # if 1st number < 2nd number, remove 2nd number and repeat
        else:
            del aList[1]
            return minInList(aList)

# generate list with 20 elements, each randomly generated from 0 to 99
my_list = [randint(0, 100) for i in range(0, 20)]
print('starting minInList function...')
print(minInList(my_list))

