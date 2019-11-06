using namespace std;

#include "childAnimal.h"
#include <iostream>
#include <string>

Dog::Dog() : Mammal() {
    cout << "constructing Dog object " << Dog::getName() << endl;
}

Dog::Dog(string n, COLOR c, string o) : Mammal(n, c), _owner(o) {
    cout << "Constructing Dog object " << Dog::getName() << endl;
}

Dog::~Dog() {
    cout << "destructing Dog object " << Dog::getName() << endl;
}

void Dog::speak() {
    cout << "Woof" << endl;
}

void Dog::move() {
    cout << "Dog move" << endl;
}

void Dog::eat() {
    cout << "Dog eat" << endl;
}

Cat::Cat() : Mammal() {
    cout << "constructing Cat object " << Cat::getName() << endl;
}

Cat::Cat(string n, COLOR c, string o) : Mammal(n, c), _owner(o) {
    cout << "Constructing Cat object " << Cat::getName() << endl;
}

Cat::~Cat() {
    cout << "destructing Cat object " << Cat::getName() << endl;
}

void Cat::speak() {
    cout << "Meow" << endl;
}

void Cat::move() {
    cout << "Cat move" << endl;
}

void Cat::eat() {
    cout << "Cat eat" << endl;
}

Lion::Lion() : Mammal() {
    cout << "constructing Lion object " << Lion::getName() << endl;
}

Lion::Lion(string n, COLOR c, string o) : Mammal(n, c), _owner(o) {
    cout << "Constructing Lion object " << Lion::getName() << endl;
}

Lion::~Lion() {
    cout << "destructing Lion object " << Lion::getName() << endl;
}

void Lion::speak() {
    cout << "Roar" << endl;
}

void Lion::move() {
    cout << "Lion move" << endl;
}

void Lion::eat() {
    cout << "Lion eat" << endl;
}