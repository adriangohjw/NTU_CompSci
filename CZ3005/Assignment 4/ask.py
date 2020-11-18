import os
import random
import sys
import asyncio
import telepot
from telepot.aio.loop import MessageLoop
from telepot.aio.delegate import pave_event_space, per_chat_id, create_open
from pyswip import Prolog

from keyboards import generateKB, ReplyKeyboardRemove
import replies
from telegram_token import TOKEN
from prolog_convertor import PrologConvertor

class TelegramBot(telepot.aio.helper.ChatHandler):
    def __init__(self, *args, **kwargs):
        super(TelegramBot, self).__init__(*args, **kwargs)
        self.prolog = PrologConvertor()


    def __restart(self):
      self.prolog = PrologConvertor()


    async def on_chat_message(self, msg):
        _, _, id = telepot.glance(msg)
        if (msg['text'] == '/start'):
            self.__restart()
            meals = self.prolog.meals()
            
            await bot.sendDocument(id, document=open('images/hello.gif', 'rb'))
            await bot.sendMessage(
                id, 
                replies.getWelcome(
                    meal_options=meals, 
                    restart=False
                ),
                reply_markup=generateKB(meals)
            )

        elif (msg['text'] == '/restart'):
            self.__restart()
            meals = self.prolog.meals()
            
            await bot.sendDocument(id, document=open('images/restart.gif', 'rb'))
            await bot.sendMessage(
                id, 
                replies.getWelcome(
                    meal_options=meals, 
                    restart=True
                ),
                reply_markup=generateKB(meals)
            )

        else:
          user_input = msg['text'].lower().replace(" ", "_")

          if (user_input in self.prolog.meals()):
            self.prolog.add_meal(user_input)
            breads = self.prolog.ask_breads()

            await bot.sendPhoto(id, photo=open('images/breads.png', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskBreads(bread_options=breads),
              reply_markup=generateKB(breads)
            )

          elif (user_input in self.prolog.breads()):
            self.prolog.add_bread(user_input)
            mains = self.prolog.ask_mains()

            await bot.sendPhoto(id, photo=open('images/mains.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskMains(main_options=mains),
              reply_markup=generateKB(mains)
            )

          elif (user_input in self.prolog.mains()):
            self.prolog.add_main(user_input)
            veggies = self.prolog.ask_veggies()

            await bot.sendPhoto(id, photo=open('images/veggies.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskVeggies(veggie_options=veggies),
              reply_markup=generateKB(veggies)
            )

          elif (user_input in self.prolog.veggies()):
            self.prolog.add_veggie(user_input)
            sauces = self.prolog.ask_sauces()
            
            await bot.sendPhoto(id, photo=open('images/sauces.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskSauces(sauce_options=sauces),
              reply_markup=generateKB(sauces)
            )

          elif (user_input in self.prolog.sauces()):
            self.prolog.add_sauce(user_input)
            topups = self.prolog.ask_topups()

            await bot.sendPhoto(id, photo=open('images/topups.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskTopups(topup_options=topups),
              reply_markup=generateKB(topups)
            )

          elif (user_input in self.prolog.topups()):
            self.prolog.add_topup(user_input)
            sides = self.prolog.ask_sides()

            await bot.sendPhoto(id, photo=open('images/sides.png', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskSides(side_options=sides),
              reply_markup=generateKB(sides)
            )

          elif (user_input in self.prolog.sides()):
            self.prolog.add_side(user_input)
            drinks = self.prolog.ask_drinks()

            await bot.sendPhoto(id, photo=open('images/drinks.png', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskDrinks(drink_options=drinks),
              reply_markup=generateKB(drinks)
            )
            
          elif (user_input in self.prolog.drinks()):
            self.prolog.add_drink(user_input)

            await bot.sendMessage(
              id, 
              replies.getOrderSummary(
                meals=self.prolog.show_meals(),
                breads=self.prolog.show_breads(), 
                mains=self.prolog.show_mains(), 
                veggies=self.prolog.show_veggies(), 
                sauces=self.prolog.show_sauces(), 
                topups=self.prolog.show_topups(), 
                sides=self.prolog.show_sides(),
                drinks=self.prolog.show_drinks()
              ),
              reply_markup=ReplyKeyboardRemove(),
              parse_mode='HTML'
            )
            await bot.sendMessage(
              id, "Wait ah, lemme prepare your order, very fast"
            )
            await bot.sendDocument(
              id, document=open('images/order_completed.gif', 'rb')
            )
            await bot.sendMessage(
              id, "Okay enjoy!"
            )
            
          else:
            print(111)
          

bot = telepot.aio.DelegatorBot(TOKEN, [
    pave_event_space()(
        per_chat_id(), create_open, TelegramBot, timeout=500),
])

loop = asyncio.get_event_loop()
loop.create_task(MessageLoop(bot).run_forever())
print('Listening ...')

loop.run_forever()