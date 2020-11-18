def getWelcome(meal_options):
  meal_options_string = ""
  counter = 0
  while counter < len(meal_options):
    meal_options_string += "{counter}: {meal}\n".format(counter=counter + 1, meal=meal_options[counter])
    counter += 1

  return (
    "Eh handsome, welcome to Subway! 😊\n\n"
    "What kind of meal you want today ah?\n"
    "{}".format(meal_options_string)
  )