package com.functionalInterface;

import java.util.function.Consumer;

public class consumerFunctionalInterface {
	public static void main(String[] args) {
		Consumer<String> con=s->System.out.println("Res:" +s.length());
		con.accept("hello");
	}
}
