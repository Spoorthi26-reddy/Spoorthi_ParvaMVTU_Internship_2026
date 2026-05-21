package com.this_super;

class Employee {
    static String company = "TCS"; 
    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name + " works at " + company);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Rahul");
        Employee e2 = new Employee("Anita");

        e1.display();
        e2.display();
    }
}
