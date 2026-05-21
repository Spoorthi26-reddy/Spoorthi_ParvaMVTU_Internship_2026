package com.set_interface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class interface1 {
	public static void main(String[] args) {
		//set
		Set<Integer> s1=new HashSet<Integer>();
		s1.add(12);
		s1.add(12);
		s1.add(5);
		s1.add(26);
		s1.add(null);
		s1.add(null);
		System.out.println(s1);
		
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(100);
		marks.add(120);
		marks.add(120);
		marks.add(140);
		marks.add(111);
		System.out.println(marks);
		Set<Integer> s2=new HashSet<Integer>(marks);
		System.out.println(s2);
		
	}
}
