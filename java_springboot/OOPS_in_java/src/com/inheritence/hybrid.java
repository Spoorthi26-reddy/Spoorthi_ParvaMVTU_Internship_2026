package com.inheritence;



class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {
    public void play() {
        System.out.println("Dog is playing");
    }
}

class Puppy extends Dog {
    void sound() {
        System.out.println("Puppy makes sound");
    }
}

public class hybrid {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();
        p.play();
        p.sound();
    }
}
