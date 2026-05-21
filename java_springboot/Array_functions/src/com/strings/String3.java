package com.strings;

public class String3 {
	public static void main(String[] args) {
		/*
		 * Strings in java are immutable : once we create string we can't be able to change the value of it
		 *  To over come this we have
		 *   	String buffer
		 *   	String Builder
		 */
		
		String str1="hello";
		System.out.println("before:" +str1);
		str1 =str1.concat("world");
		System.out.println("after:" +str1);
	}

}
