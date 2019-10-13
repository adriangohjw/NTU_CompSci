# list is the list to be searched through
# start is the original index of the first item in the list
# end is the original index of the last item in the list
# n is the value you want to find
def binarysearch(list, start, end, x):
    if end < start:
        return -1
    else:
        mid = (start + end) // 2
        if list[mid] == x:
            return mid
        elif x < list[mid]:  # if x is smaller than middle (on the left)
            return binarysearch(list, start, mid-1, x)
        else:  # if x is larger than middle (on the right)
            return binarysearch(list, mid+1, end, x)


testList_even = [1, 2, 4, 7, 11, 16]  # test data set (even number of items)
print("Original list is " + str(testList_even))
print("16 is found in index " + str(binarysearch(testList_even, 0, len(testList_even)-1, 16)))
print("13 is found in index " + str(binarysearch(testList_even, 0, len(testList_even)-1, 13)))

testList_odd = [1, 2, 4, 7, 11, 16, 22]  # test data set (odd number of items)
print("Original list is " + str(testList_odd))
print("16 is found in index " + str(binarysearch(testList_odd, 0, len(testList_odd)-1, 16)))
print("13 is found in index " + str(binarysearch(testList_odd, 0, len(testList_odd)-1, 13)))