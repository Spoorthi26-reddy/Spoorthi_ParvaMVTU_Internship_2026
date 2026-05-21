package com.methods;

import java.util.function.Consumer;

public class StaticMethodReference {
	
		public static void printMessage(String Message) {
			System.out.println("your message is:" +Message);
		}
		public static void main(String[] args) {
			//without static method
			Consumer<String> cons1 = s-> StaticMethodReference.printMessage(s);
			cons1.accept("hello");
			//with static method
			Consumer<String> cons2 = StaticMethodReference::printMessage;
			cons2.accept("hello");
			
	}
}
