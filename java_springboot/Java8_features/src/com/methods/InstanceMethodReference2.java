package com.methods;

import java.util.Arrays;

public class InstanceMethodReference2 {
	public static void main(String[] args) {
		String names []= {"ram","ram","sita","sita","laxman"};
		//without
		Arrays.sort(names,(s1,s2)->s1.compareToIgnoreCase(s2));
		System.out.println(Arrays.toString(names));
		//with
		Arrays.sort(names,String::compareToIgnoreCase);
		System.out.println(Arrays.toString(names));
		
	}
}
