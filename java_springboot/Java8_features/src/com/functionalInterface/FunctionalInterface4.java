package com.functionalInterface;
//@FunctionalInterface
interface CustomStringLength{
	int str_len(String str);
}
public class FunctionalInterface4 {
	public static void main(String[] args) {
		CustomStringLength obj=(str->str.length());
		int res= obj.str_len("hello");
		System.out.println(res);
	}

}
