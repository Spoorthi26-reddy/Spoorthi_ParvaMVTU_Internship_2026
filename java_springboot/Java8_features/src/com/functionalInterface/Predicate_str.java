package com.functionalInterface;

import java.util.function.Predicate;

public class Predicate_str {
	public static void main(String[] args) {
		Predicate<String> str=s->s.length()>5;
		
		System.out.println(str.test("spoo"));
	}
}
