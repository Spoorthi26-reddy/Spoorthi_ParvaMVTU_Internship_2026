package com.functionalInterface;

import java.util.function.Predicate;

public class predicateFubctionalInterface {
	public static void main(String[] args) {
		//even or odd using predicate(boolean)
		Predicate<Integer> pre = a->a%2==0;
		System.out.println(pre.test(13));
	}
	
}
