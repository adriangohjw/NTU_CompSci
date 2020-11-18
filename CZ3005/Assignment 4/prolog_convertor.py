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


  def ask_meals(self):
    res = list(self.prolog.query("ask_meals(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_breads(self):
    res = list(self.prolog.query("ask_breads(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_mains(self):
    res = list(self.prolog.query("ask_mains(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_veggies(self):
    res = list(self.prolog.query("ask_veggies(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_sauces(self):
    res = list(self.prolog.query("ask_sauces(X)"))[0]["X"]
    return self.convert_res_to_list(res)

  
  def ask_topups(self):
    res = list(self.prolog.query("ask_topups(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def ask_sides(self):
    res = list(self.prolog.query("ask_sides(X)"))[0]["X"]
    return self.convert_res_to_list(res)


  def convert_res_to_list(self, res):
    counter = 0
    list_result = []
    while (counter < len(res)):
      list_result.append(res[counter].value)
      counter += 1
    return list_result