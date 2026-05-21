package com.this_super;

class Animal{
	String name;
	
	public Animal(String name) {
		super();
		this.name=name;
		System.out.println("Animal constructor called");
	}
	public void display() {
		System.out.println("parent method");
	}
}

class Dog extends Animal{
	String name;
	String breed;
	public Dog(String name,String breed) {
		super("parent1");
		this.name=name;
		this.breed=breed;
	}
	@Override
	public void display() {
		super.display();
		System.out.println("Dog name: "+this.name);
		System.out.println("Dog parent name:"+super.name);
	}
}



public class SuperKeyword {
	public static void main(String[] args) {
		Dog d1=new Dog("Dog1","Breed1");
		d1.display();
	}

}