from pyswip import Prolog

PROLOG_FILENAME = "ADRIAN_GOH_JUN_WEI_qn_3.pl"

class PrologConvertor():
  def __init__(self):
    self.prolog = Prolog()
    self.prolog.consult(PROLOG_FILENAME)


  def meals(self):
    res = list(self.prolog.query("meals(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def breads(self):
    res = list(self.prolog.query("breads(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def mains(self):
    res = list(self.prolog.query("mains(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def veggies(self):
    res = list(self.prolog.query("veggies(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def sauces(self):
    res = list(self.prolog.query("fatty_sauces(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def topups(self):
    res = list(self.prolog.query("cheese_topups(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def sides(self):
    res = list(self.prolog.query("sides(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def add_meal(self, X):
    self.prolog.assertz("chosen_meals({})".format(X))


  def add_bread(self, X):
    self.prolog.assertz("chosen_breads({})".format(X))


  def add_main(self, X):
    self.prolog.assertz("chosen_mains({})".format(X))

  
  def add_veggie(self, X):
    self.prolog.assertz("chosen_veggies({})".format(X))


  def add_sauce(self, X):
    self.prolog.assertz("chosen_sauces({})".format(X))


  def add_topup(self, X):
    self.prolog.assertz("chosen_topups({})".format(X))


  def add_side(self, X):
    self.prolog.assertz("chosen_sides({})".format(X))


  def ask_meals(self):
    res = list(self.prolog.query("ask_meals(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_breads(self):
    res = list(self.prolog.query("ask_breads(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_mains(self):
    res = list(self.prolog.query("ask_mains(X)"))[0]["X"]
    if not res:
      return []
    else:
      return self.convert_res_to_list(res[0])


  def ask_veggies(self):
    res = list(self.prolog.query("ask_veggies(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_sauces(self):
    res = list(self.prolog.query("ask_sauces(X)"))[0]["X"]
    if not res:
      return []
    else:
      return self.convert_res_to_list(res[0])

  
  def ask_topups(self):
    res = list(self.prolog.query("ask_topups(X)"))[0]["X"]
    if not res:
      return []
    else:
      return self.convert_res_to_list(res[0])


  def ask_sides(self):
    res = list(self.prolog.query("ask_sides(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def show_meals(self):
    res = list(self.prolog.query("show_meals(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def show_breads(self):
    res = list(self.prolog.query("show_breads(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def show_mains(self):
    res = list(self.prolog.query("show_mains(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def show_veggies(self):
    res = list(self.prolog.query("show_veggies(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def show_sauces(self):
    res = list(self.prolog.query("show_sauces(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def show_topups(self):
    res = list(self.prolog.query("show_topups(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def show_sides(self):
    res = list(self.prolog.query("show_sides(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def convert_res_to_list(self, res):
    counter = 0
    list_result = []
    while (counter < len(res)):
      list_result.append(res[counter].value)
      counter += 1
    return list_result