def getWelcome(meal_options, restart=False):
    meal_options_string = __convertListToNumberedString(meal_options)

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


def getOrderSummary(meals, breads, mains, veggies, sauces, topups, sides):
    return (
        "Swee lah, come, I repeat your order\n\n"
        "<b>🍽️ Meal</b>\n"
        "{meals}\n"
        "<b>🍞 Bread</b>\n"
        "{breads}\n"
        "<b>🍖 Main</b>\n"
        "{mains}\n"
        "<b>🥬 Veggie</b>\n"
        "{veggies}\n"
        "<b>🥣 Sauce</b>\n"
        "{sauces}\n"
        "<b>🧀 Topup</b>\n"
        "{topups}\n"
        "<b>🍪 Side</b>\n"
        "{sides}\n"
        "Bye!"
    ).format(
        meals=__convertListToNumberedString(meals), 
        breads=__convertListToNumberedString(breads), 
        mains=__convertListToNumberedString(mains), 
        veggies=__convertListToNumberedString(veggies), 
        sauces=__convertListToNumberedString(sauces), 
        topups=__convertListToNumberedString(topups), 
        sides=__convertListToNumberedString(sides)
    )


def __convertListToNumberedString(list_input):
    string = ""
    for item in list_input:
        string += "• {item}\n".format(item=item)
    return string
    