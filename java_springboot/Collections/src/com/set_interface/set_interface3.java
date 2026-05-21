package com.set_interface;


import java.util.Set;
import java.util.TreeSet;

public class set_interface3 {
	public static void main(String[] args) {
		//Set<Integer> s1=new TreeSet<Integer>();
		Set<Integer> s1=new TreeSet<Integer>((a,b)->b-a);
		s1.add(12);
		s1.add(12);
		s1.add(5);
		s1.add(26);
		System.out.println(s1);
		
	}
}
