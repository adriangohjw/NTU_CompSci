my_file = open('lab5_dictionary.txt', 'r')
list_v = [word.replace('\n', '') for word in my_file if word[0].lower() == 'v']
print("This will print all words starting with 'v' that is an anagrams with your input")


def main():
    user_input = ''.join(sorted(input('Please key in the word you want to look up')))
    anagrams = [word for word in list_v if user_input.lower() == ''.join(sorted(word.lower()))]
    print(anagrams)

while 1:
    main()