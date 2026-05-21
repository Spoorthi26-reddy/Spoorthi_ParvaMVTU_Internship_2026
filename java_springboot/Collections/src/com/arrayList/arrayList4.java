package com.arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class arrayList4 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(30);
		al.add(140);
		al.add(150);
		al.add(180);
		al.add(100);
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
		System.out.println("Min:" +Collections.min(al));
		System.out.println("Max:" +Collections.max(al));
		System.out.println("Binary search:" +Collections.binarySearch(al,140));
		
}
}
