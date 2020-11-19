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


  def all_options(self, category):
    res = list(self.prolog.query("all_options({}, X)".format(category)))[0]["X"]
    return self.convert_res_to_list(res)


  def available_options(self, category):
    res = list(self.prolog.query("available_options({}, X)".format(category)))[0]["X"]
    return self.convert_res_to_list(res)


  def selected_options(self, category):
    res = list(self.prolog.query("selected_options({}, X)".format(category)))[0]["X"]
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


  def convert_res_to_list(self, res):
    counter = 0
    list_result = []
    while (counter < len(res)):
      list_result.append(res[counter].value)
      counter += 1
    return list_result