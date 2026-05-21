package com.strings;

public class StringBuilderMethods {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello");

        // append()
        sb.append(" Java");
        System.out.println("After append: " + sb);

        // insert()
        sb.insert(5, " World");
        System.out.println("After insert: " + sb);

        // replace()
        sb.replace(6, 11, "Hi");
        System.out.println("After replace: " + sb);

        // delete()
        sb.delete(5, 8);
        System.out.println("After delete: " + sb);

        // reverse()
        sb.reverse();
        System.out.println("After reverse: " + sb);
   
	}
}
