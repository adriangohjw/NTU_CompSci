from telepot.namedtuple import ReplyKeyboardMarkup, ReplyKeyboardRemove

def generateKB(options):
  new_list = []
  for item in options:
    new_list.append(item.capitalize().replace("_", " "))

  return ReplyKeyboardMarkup(keyboard=[new_list])
