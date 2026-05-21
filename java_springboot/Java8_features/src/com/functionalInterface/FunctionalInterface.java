package com.functionalInterface;

import java.util.function.Function;

public class FunctionalInterface {
	public static void main(String[] args) {
		Function<String, Integer> fun =(s)->s.length();
		int res=fun.apply("helloooo");
		System.out.println(res);
	}
}
