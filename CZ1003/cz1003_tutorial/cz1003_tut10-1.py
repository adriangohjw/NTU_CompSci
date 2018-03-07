file_a = open('cz1003_tut10-1-a.txt', 'r')
list_a = []
for i in file_a:
    list_a.append(i.replace('\n', ''))
file_a.close()

file_b = file_b = open('cz1003_tut10-1-b.txt', 'r')
list_b = []
for i in file_b:
    list_b.append(i.replace('\n', ''))
file_b.close()

for i in range(len(list_a)-1, -1, -1):
    for j in range(len(list_b)-1, -1, -1):
        if list_a[i] == list_b[j]:
            list_a.remove(list_a[i])
            list_b.remove(list_b[j])
            break
print()
print(list_a)
print(list_b)

file_to_save = open('cz1003_tut10-1-output.txt', 'w')

file_to_save.write("This is in file A only\n")
count_a = 0
for i in list_a:
    file_to_save.write(i)
    file_to_save.write('\n')
    count_a += 1
file_to_save.write('\n')

file_to_save.write("This is in file B only\n")
count_b = 0
for j in list_b:
    file_to_save.write(j)
    file_to_save.write('\n')
    count_b += 1
file_to_save.write('\n')

file_to_save.write('Number of different line(s) in file A: {}\n'.format(count_a))
file_to_save.write('Number of different line(s) in file B: {}'.format(count_b))

file_to_save.close()

