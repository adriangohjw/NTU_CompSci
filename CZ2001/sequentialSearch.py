# list is the list to be searched through
# n is the value you want to find
def sequentialsearch(list, x):
    for i in range(0, len(list), 1):
        if list[i] == x:
            return i
    return -1


testList = [45, 29, 6, 64, 12, 16]  # test data set

print("Original list is " + str(testList))
print("12 is found in index " + str(sequentialsearch(testList, 12)))
print("13 is found in index " + str(sequentialsearch(testList, 13))) 