package com.set_interface;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class set_interface2 {
	public static void main(String[] args) {
		Set<Integer> s1=new HashSet<Integer>();
		s1.add(12);
		s1.add(12);
		s1.add(5);
		s1.add(26);
		
		//we cannot use normal for loop because set does not contain indexed values
		
//enhanced for loop
		for(int ele:s1) {
			System.out.println(ele+" ");
		}
		System.out.println();
//for each loop
		s1.forEach((ele)->System.out.println(ele+" "));
		System.out.println();
		
//iterator
		Iterator<Integer> iterator=s1.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+" ");
		}
	}
}
