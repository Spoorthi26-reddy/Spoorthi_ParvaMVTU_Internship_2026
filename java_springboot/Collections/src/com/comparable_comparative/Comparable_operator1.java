package com.comparable_comparative;

import java.util.ArrayList;
import java.util.Collections;



public class Comparable_operator1 {
	public static void main(String[] args) {
		//comparable-default
		//comparator-natural sorting
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(1000);
		arr.add(30);
		arr.add(26);
		arr.add(5);
		arr.add(12);
		Collections.sort(arr);
		System.out.println("using comparable:" +arr);
		Collections.sort(arr,(a1,a2)->a2-a1);
		System.out.println("using comparator:" +arr);
	}
}
