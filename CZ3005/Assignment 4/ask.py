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
        self.question_lists = ['meals', 'breads', 'mains', 'veggies', 'sauces', 'topups', 'sides', 'drinks']
        self.counter = 0


    def __restart(self):
      self.prolog = PrologConvertor()
      self.counter = 0


    async def __updateCounter(self):
        try:
            question = self.question_lists[self.counter]

            if question == 'meals':
                options = self.prolog.available_options(question)

            elif question == 'breads':
                options = self.prolog.available_options(question)
                
            elif question == 'mains':
                options = self.prolog.available_options(question)

            elif question == 'veggies':
                options = self.prolog.available_options(question)

            elif question == 'sauces':
                options = self.prolog.available_options(question)

            elif question == 'topups':
                options = self.prolog.available_options(question)

            elif question == 'sides':
                options = self.prolog.available_options(question)

            elif question == 'drinks':
                options = self.prolog.available_options(question)

            else:
                print("Error")

            if not options: # if empty
                self.counter += 1

        except:
            pass


    async def __ask(self, id, bot, question):
        self.counter += 1

        if question == 'meals':
            meals = self.prolog.available_options(question)

            #await bot.sendDocument(id, document=open('images/hello.gif', 'rb'))
            await bot.sendMessage(
                id, 
                replies.getWelcome(
                    meal_options=meals, 
                    restart=False
                ),
                reply_markup=generateKB(meals)
            )

        elif question == 'breads':
            breads = self.prolog.available_options(question)

            #await bot.sendPhoto(id, photo=open('images/breads.png', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskBreads(bread_options=breads),
              reply_markup=generateKB(breads)
            )

        elif question == 'mains':
            mains = self.prolog.available_options(question)

            #await bot.sendPhoto(id, photo=open('images/mains.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskMains(main_options=mains),
              reply_markup=generateKB(mains)
            )

        elif question == 'veggies':
            veggies = self.prolog.available_options(question)

            #await bot.sendPhoto(id, photo=open('images/veggies.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskVeggies(veggie_options=veggies),
              reply_markup=generateKB(veggies)
            )

        elif question == 'sauces':
            sauces = self.prolog.available_options(question)
            
            #await bot.sendPhoto(id, photo=open('images/sauces.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskSauces(sauce_options=sauces),
              reply_markup=generateKB(sauces)
            )

        elif question == 'topups':
            topups = self.prolog.available_options(question)

            #await bot.sendPhoto(id, photo=open('images/topups.jpg', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskTopups(topup_options=topups),
              reply_markup=generateKB(topups)
            )

        elif question == 'sides':
            sides = self.prolog.available_options(question)

            #await bot.sendPhoto(id, photo=open('images/sides.png', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskSides(side_options=sides),
              reply_markup=generateKB(sides)
            )

        elif question == 'drinks':
            drinks = self.prolog.available_options(question)

            #await bot.sendPhoto(id, photo=open('images/drinks.png', 'rb'))
            await bot.sendMessage(
              id, 
              replies.getAskDrinks(drink_options=drinks),
              reply_markup=generateKB(drinks)
            )

        else:
            self.counter += 0
            await bot.sendMessage(
              id, 
              replies.getOrderSummary(
                meals=self.prolog.selected_options("meals"),
                breads=self.prolog.selected_options("breads"), 
                mains=self.prolog.selected_options("mains"), 
                veggies=self.prolog.selected_options("veggies"), 
                sauces=self.prolog.selected_options("sauces"), 
                topups=self.prolog.selected_options("topups"), 
                sides=self.prolog.selected_options("sides"),
                drinks=self.prolog.selected_options("drinks")
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
            await bot.sendMessage(
              id, "Want to start a new order? Click /restart"
            )


    async def on_chat_message(self, msg):
        _, _, id = telepot.glance(msg)

        if msg['text'] == '/start':
            self.__restart()
            await self.__ask(id, bot, self.question_lists[self.counter])

        elif msg['text'] == '/restart':
            self.__restart()
            meals = self.prolog.available_options("meals")
            
            #await bot.sendDocument(id, document=open('images/restart.gif', 'rb'))
            await bot.sendMessage(
                id, 
                replies.getWelcome(
                    meal_options=meals, 
                    restart=True
                ),
                reply_markup=generateKB(meals)
            )
            self.counter += 1

        else:
            user_input = msg['text'].lower().replace(" ", "_")

            if user_input not in self.prolog.all_options("drinks"):
                if user_input in self.prolog.all_options("meals"):
                    self.prolog.add_meal(user_input)

                elif user_input in self.prolog.all_options("breads"):
                    self.prolog.add_bread(user_input)

                elif user_input in self.prolog.all_options("mains"):
                    self.prolog.add_main(user_input)

                elif user_input in self.prolog.all_options("veggies"):
                    self.prolog.add_veggie(user_input)
                    
                elif user_input in self.prolog.all_options("sauces"):
                    self.prolog.add_sauce(user_input)

                elif user_input in self.prolog.all_options("topups"):
                    self.prolog.add_topup(user_input)

                elif user_input in self.prolog.all_options("sides"):
                    self.prolog.add_side(user_input)

                await self.__updateCounter()
                await self.__ask(id, bot, self.question_lists[self.counter])

            else:
                self.prolog.add_drink(user_input)
                await self.__updateCounter()
                await self.__ask(id, bot, None)
          

bot = telepot.aio.DelegatorBot(TOKEN, [
    pave_event_space()(
        per_chat_id(), create_open, TelegramBot, timeout=500),
])

loop = asyncio.get_event_loop()
loop.create_task(MessageLoop(bot).run_forever())
print('Listening ...')

loop.run_forever()