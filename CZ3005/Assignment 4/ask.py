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
        if (msg['text'] in ['/start', '/restart']):
            self.__restart()
            meals = self.prolog.meals()
            
            await bot.sendMessage(
                id, 
                replies.getWelcome(
                    meal_options=meals, 
                    restart=(msg['text']=='/restart')
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
              "placeholder - breads",
              reply_markup=generateKB(breads)
            )

          elif (user_input in self.prolog.breads()):
            self.prolog.add_bread(user_input)
            mains = self.prolog.ask_mains()

            await bot.sendMessage(
              id, 
              "placeholder - mains",
              reply_markup=generateKB(mains)
            )

          elif (user_input in self.prolog.mains()):
            self.prolog.add_main(user_input)
            veggies = self.prolog.ask_veggies()

            await bot.sendMessage(
              id, 
              "placeholder - veggies",
              reply_markup=generateKB(veggies)
            )

          elif (user_input in self.prolog.veggies()):
            self.prolog.add_veggie(user_input)
            sauces = self.prolog.ask_sauces()
            
            await bot.sendMessage(
              id, 
              "placeholder - sauces",
              reply_markup=generateKB(sauces)
            )

          elif (user_input in self.prolog.sauces()):
            self.prolog.add_sauce(user_input)
            topups = self.prolog.ask_topups()

            await bot.sendMessage(
              id, 
              "placeholder - topups",
              reply_markup=generateKB(topups)
            )

          elif (user_input in self.prolog.topups()):
            self.prolog.add_topup(user_input)
            sides = self.prolog.ask_sides()

            await bot.sendMessage(
              id, 
              "placeholder - sides",
              reply_markup=generateKB(sides)
            )
            
          elif (user_input in self.prolog.sides()):
            self.prolog.add_side(user_input)

            await bot.sendMessage(
              id, 
              replies.getOrderSummary(
                meals=self.prolog.show_meals(),
                breads=self.prolog.show_breads(), 
                mains=self.prolog.show_mains(), 
                veggies=self.prolog.show_veggies(), 
                sauces=self.prolog.show_sauces(), 
                topups=self.prolog.show_topups(), 
                sides=self.prolog.show_sides()
              ),
              reply_markup=ReplyKeyboardRemove(),
              parse_mode='HTML'
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