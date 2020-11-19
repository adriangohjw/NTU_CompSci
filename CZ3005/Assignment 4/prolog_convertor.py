from pyswip import Prolog, prolog

PROLOG_FILENAME = "ADRIAN_GOH_JUN_WEI_qn_3.pl"

class PrologConvertor():
  def __init__(self):
    self.prolog = Prolog()
    self.prolog.consult(PROLOG_FILENAME)
    self.__retractall()


  def __retractall(self):
    self.prolog.retractall("selected_meals(X)")
    self.prolog.retractall("selected_breads(X)")
    self.prolog.retractall("selected_mains(X)")
    self.prolog.retractall("selected_veggies(X)")
    self.prolog.retractall("selected_sauces(X)")
    self.prolog.retractall("selected_topups(X)")
    self.prolog.retractall("selected_sides(X)")
    self.prolog.retractall("selected_drinks(X)")


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
    res = list(self.prolog.query("sauces(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def topups(self):
    res = list(self.prolog.query("topups(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def sides(self):
    res = list(self.prolog.query("sides(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def drinks(self):
    res = list(self.prolog.query("drinks(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def add_meal(self, X):
    self.prolog.assertz("selected_meals({})".format(X))


  def add_bread(self, X):
    self.prolog.assertz("selected_breads({})".format(X))


  def add_main(self, X):
    self.prolog.assertz("selected_mains({})".format(X))

  
  def add_veggie(self, X):
    self.prolog.assertz("selected_veggies({})".format(X))


  def add_sauce(self, X):
    self.prolog.assertz("selected_sauces({})".format(X))


  def add_topup(self, X):
    self.prolog.assertz("selected_topups({})".format(X))


  def add_side(self, X):
    self.prolog.assertz("selected_sides({})".format(X))


  def add_drink(self, X):
    self.prolog.assertz("selected_drinks({})".format(X))


  def ask_meals(self):
    res = list(self.prolog.query("ask_meals(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_breads(self):
    res = list(self.prolog.query("ask_breads(X)"))[0]["X"]
    if not res:
      return []
    elif type(res[0][0]).__name__ == "Atom":
      return self.convert_res_to_list(res[0])
    else:
      return self.convert_res_to_list(res[0][0])


  def ask_mains(self):
    res = list(self.prolog.query("ask_mains(X)"))[0]["X"]
    if not res:
      return []
    elif type(res[0][0]).__name__ == "Atom":
      return self.convert_res_to_list(res[0])
    else:
      return self.convert_res_to_list(res[0][0])


  def ask_veggies(self):
    res = list(self.prolog.query("ask_veggies(X)"))[0]["X"]
    if not res:
      return []
    else:
      return self.convert_res_to_list(res[0])


  def ask_sauces(self):
    res = list(self.prolog.query("ask_sauces(X)"))[0]["X"]
    if not res:
      return []
    elif type(res[0][0]).__name__ == "Atom":
      return self.convert_res_to_list(res[0])
    else:
      return self.convert_res_to_list(res[0][0])

  
  def ask_topups(self):
    res = list(self.prolog.query("ask_topups(X)"))[0]["X"]
    if not res:
      return []
    elif type(res[0][0]).__name__ == "Atom":
      return self.convert_res_to_list(res[0])
    else:
      return self.convert_res_to_list(res[0][0])


  def ask_sides(self):
    res = list(self.prolog.query("ask_sides(X)"))[0]["X"]
    if not res:
      return []
    elif type(res[0][0]).__name__ == "Atom":
      return self.convert_res_to_list(res[0])
    else:
      return self.convert_res_to_list(res[0][0])


  def ask_drinks(self):
    res = list(self.prolog.query("ask_drinks(X)"))[0]["X"]
    if not res:
      return []
    elif type(res[0][0]).__name__ == "Atom":
      return self.convert_res_to_list(res[0])
    else:
      return self.convert_res_to_list(res[0][0])


  def show_meals(self):
    try: 
      res = list(self.prolog.query("show_meals(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def show_breads(self):
    try: 
      res = list(self.prolog.query("show_breads(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def show_mains(self):
    try: 
      res = list(self.prolog.query("show_mains(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def show_veggies(self):
    try: 
      res = list(self.prolog.query("show_veggies(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def show_sauces(self):
    try: 
      res = list(self.prolog.query("show_sauces(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def show_topups(self):
    try: 
      res = list(self.prolog.query("show_topups(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def show_sides(self):
    try: 
      res = list(self.prolog.query("show_sides(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def show_drinks(self):
    try: 
      res = list(self.prolog.query("show_drinks(X)"))[0]["X"]
      return self.convert_res_to_list(res)
    except prolog.PrologError:
      return []


  def convert_res_to_list(self, res):
    counter = 0
    list_result = []
    while (counter < len(res)):
      list_result.append(res[counter].value)
      counter += 1
    return list_result