package com.strings;

public class Strings2 {
	public static void main(String[] args) {
		/*
		 * String comparison: 	
		 * 1.equals()--> it will check the values
		 * 2.== --> check both value and reference
		 * 3.compareTo() --> it will check bytes
		 * 			if two equal --> 0
		 * 			if str1 > str2 --> >0
		 * 			if str1 < str2 --> <0
		 * 	 
		 */
		
		String str1 = "hello";
		String str2= new String("world");
		String str3="hello";
		String str4=new String("hello");
		
		
		System.out.println("str1.str2:"+str1.equals(str2));
		System.out.println("str1 == str2:"+ (str1==str2));
		System.out.println("str1 == str3:"+ (str1==str3));
		System.out.println("str2 == str4:"+ (str2==str4));
		System.out.println("str1 comp str3:"+str1.compareTo(str3));
	}
}
