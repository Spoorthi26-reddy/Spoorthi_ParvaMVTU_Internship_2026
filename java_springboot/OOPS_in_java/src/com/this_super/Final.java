package com.this_super;

class Demo {
    final int x = 10; 

    void change() {
       
        System.out.println(x);
    }
}

public class Final {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.change();
    }
}
