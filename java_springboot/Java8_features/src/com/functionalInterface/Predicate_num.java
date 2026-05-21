package com.functionalInterface;

import java.util.function.Predicate;

public class Predicate_num {
	public static void main(String[] args) {
		Predicate<Integer> p=I->I>50;
		System.out.println(p.test(34));
		System.out.println(p.test(78));
	}
}
