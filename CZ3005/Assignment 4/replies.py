def getWelcome(meal_options, restart=False):
    meal_options_string = ""
    counter = 0
    while counter < len(meal_options):
        meal_options_string += "{counter}: {meal}\n".format(counter=counter + 1, meal=meal_options[counter])
        counter += 1

    if (restart):
        return (
            "Haiyaaa, why you no say from the start, waste my time 🤬\n\n"
            "Come, tell me, what you want?\n"
            "{}".format(meal_options_string)
        )
    else:
        return (
            "Eh handsome, welcome to Subway! 😊\n\n"
            "What kind of meal you want today ah?\n"
            "{}".format(meal_options_string)
        )