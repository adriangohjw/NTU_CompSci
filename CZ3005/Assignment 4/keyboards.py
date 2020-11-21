from telepot.namedtuple import ReplyKeyboardMarkup, KeyboardButton, ReplyKeyboardRemove

def generateKB(options, add_skip=False):
  new_list = []
  for item in options:
    new_list.append(item.capitalize().replace("_", " "))
  
  if add_skip:
    new_list += ["🙅‍♂️ Skip"]

  n = 2
  new_segmented_list = [new_list[i * n:(i + 1) * n] for i in range((len(new_list) + n - 1) // n )]

  keyboard_list = []
  for inner_list in new_segmented_list:
    temp_list = []
    for item in inner_list:
      temp_list.append(KeyboardButton(text=item))
    keyboard_list.append(temp_list)
    
  return ReplyKeyboardMarkup(keyboard=keyboard_list, resize_keyboard=True, one_time_keyboard=True)
