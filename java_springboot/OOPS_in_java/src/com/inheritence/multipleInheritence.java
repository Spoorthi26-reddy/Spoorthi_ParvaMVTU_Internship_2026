package com.inheritence;


interface Domestic {
    void eat();
}

interface home {
    void play();
}

class crow implements Domestic, home {

    public void eat() {
        System.out.println("crow is eating");
    }

    public void play() {
        System.out.println("crow is playing");
    }
}

public class multipleInheritence {
    public static void main(String[] args) {
        crow d = new crow();
        d.eat();
        d.play();
    }
}