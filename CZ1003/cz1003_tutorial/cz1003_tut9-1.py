my_list = list(range(1, 11))
print(my_list)


def maxInList(aList):  # non-recursion method
    max_number = aList[0]
    for i in range(1, len(aList)):
        if max_number < aList[i]:
            max_number = aList[i]
    return max_number


def minInList(aList):  # non-recursion method
    min_number = aList[0]
    for i in range(1, len(aList)):
        if min_number > aList[i]:
            min_number = aList[i]
    return min_number

print(maxInList(my_list))
print(minInList(my_list))

