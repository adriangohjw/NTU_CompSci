from telepot.namedtuple import ReplyKeyboardMarkup, ReplyKeyboardRemove

def generateKB(options):
  return ReplyKeyboardMarkup(keyboard=[options])
