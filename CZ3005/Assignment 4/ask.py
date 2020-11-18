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

        self.all_meal_options = self.prolog.meals()
        self.all_bread_options = self.prolog.breads()
        self.all_main_options = self.prolog.mains()
        self.all_veggie_options = self.prolog.veggies()
        self.all_sauce_options = self.prolog.sauces()
        self.all_topup_options = self.prolog.topups()
        self.all_side_options = self.prolog.sides()


    def __restart(self):
      self.prolog = PrologConvertor()


    async def on_chat_message(self, msg):
        _, _, id = telepot.glance(msg)
        if (msg['text'] in ['/start', '/restart']):
            self.__restart()
            meals = self.all_meal_options
            
            await bot.sendMessage(
                id, 
                replies.getWelcome(
                    meal_options=meals, 
                    restart=(msg['text']=='/restart')
                ),
                reply_markup=generateKB(meals)
            )

        else:
          if (msg['text'] in self.all_meal_options):
            self.prolog.add_meal(msg['text'])
            breads = self.prolog.ask_breads()

            await bot.sendPhoto(id, photo=open('images/breads.png', 'rb'))
            await bot.sendMessage(
              id, 
              "placeholder - breads",
              reply_markup=generateKB(breads)
            )

          elif (msg['text'] in self.all_bread_options):
            self.prolog.add_bread(msg['text'])
            mains = self.prolog.ask_mains()

            await bot.sendMessage(
              id, 
              "placeholder - mains",
              reply_markup=generateKB(mains)
            )

          elif (msg['text'] in self.all_main_options):
            self.prolog.add_main(msg['text'])
            veggies = self.prolog.ask_veggies()

            await bot.sendMessage(
              id, 
              "placeholder - veggies",
              reply_markup=generateKB(veggies)
            )

          elif (msg['text'] in self.all_veggie_options):
            self.prolog.add_veggie(msg['text'])
            sauces = self.prolog.ask_sauces()
            
            await bot.sendMessage(
              id, 
              "placeholder - sauces",
              reply_markup=generateKB(sauces)
            )

          elif (msg['text'] in self.all_sauce_options):
            self.prolog.add_sauce(msg['text'])
            topups = self.prolog.ask_topups()

            await bot.sendMessage(
              id, 
              "placeholder - topups",
              reply_markup=generateKB(topups)
            )

          elif (msg['text'] in self.all_topup_options):
            self.prolog.add_topup(msg['text'])
            sides = self.prolog.ask_sides()

            await bot.sendMessage(
              id, 
              "placeholder - sides",
              reply_markup=generateKB(sides)
            )
            
          elif (msg['text'] in self.all_side_options):
            self.prolog.add_side(msg['text'])

            await bot.sendMessage(
              id, 
              "thank you!",
              reply_markup=ReplyKeyboardRemove()
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