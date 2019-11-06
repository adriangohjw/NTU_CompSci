using namespace std;

#include <iostream>
#include <string>
#pragma once

enum COLOR { Green, Blue, White, Black, Brown } ;

class Animal {
    private :
        string _name;
        COLOR _color ;

    public:      
        Animal();
        Animal(string n, COLOR c);

        ~Animal();
        
        virtual void speak() const;
        virtual void move() = 0;

        string getName();
        void setName(string name);
        COLOR getColor();
};

class Mammal: public Animal {
    public:
        Mammal();
        Mammal(string n, COLOR c);
        
        ~Mammal();

        virtual void eat() const;
        virtual void move() const;
};