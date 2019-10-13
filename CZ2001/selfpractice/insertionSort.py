def insertionsort(listToBeSorted):
    for i in range(1, len(listToBeSorted), 1):
        for j in range(i, 0, -1):
            if listToBeSorted[j] < listToBeSorted[j-1]:
                listToBeSorted[j], listToBeSorted[j-1] = listToBeSorted[j-1], listToBeSorted[j]  # swapping
            else:
                break
    return listToBeSorted


testList = [45, 29, 6, 64, 12, 16]  # test data set

print("Original list is " + str(testList))
testList = insertionsort(testList)
print("Sorted list is " + str(testList)) 