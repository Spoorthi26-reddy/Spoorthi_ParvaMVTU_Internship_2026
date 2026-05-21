package com.functionalInterface;

import java.util.function.Predicate;

public class predicate_add {
	public static void main(String[] args) {
		int x[]= {1,2,3,4,5,6};
		Predicate<Integer> p1= I->I%2==0;
		Predicate<Integer> p2= I->I>2;
		System.out.println(p1.test(4));
		System.out.println(p2.test(3));
		
		
		
	}
}
