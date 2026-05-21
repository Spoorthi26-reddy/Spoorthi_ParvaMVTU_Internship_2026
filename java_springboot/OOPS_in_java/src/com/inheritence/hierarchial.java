package com.inheritence;

class wild {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class cow extends wild {
    void eat() {
        System.out.println("cow is eating");
    }
}

class Cat extends wild {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

public class hierarchial {
    public static void main(String[] args) {
        cow d = new cow();
        Cat c = new Cat();

        d.eat();
        

        c.eat();
        c.meow();
    }
}
