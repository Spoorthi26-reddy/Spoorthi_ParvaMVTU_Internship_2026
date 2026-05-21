package com.strings;

public class Strings1 {
	public static void main(String[] args) {
		/*string : String is an object in java, it is a collection of characters
		 * Two types:
		 *   1. String literals : It will store in string constant pool )SCP
		 *                   String str_name ="value";
		 *   2. Using new: store in heap memory
		 *                    String str_name = new String("value");
		 */
		
		String str1 = "hello";
		String Str2= new String("world");
		System.out.println("str1: "+str1);
		System.out.println("str2: "+Str2);
	}
}
