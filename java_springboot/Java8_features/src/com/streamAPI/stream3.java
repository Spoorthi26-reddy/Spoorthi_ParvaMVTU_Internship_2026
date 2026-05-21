package com.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream3 {
	 public static void main(String[] args) {
		ArrayList<Integer> l1= new ArrayList<Integer>(Arrays.asList(10,202,30,40));
		System.out.println(l1);
		//using filter-no>20
		List<Integer> collect = l1.stream().filter(i-> i>10).collect(Collectors.toList());
		System.out.println(collect);
		//using map-no+5
		List<Integer> collect2 = l1.stream().map(n->n+5).collect(Collectors.toList());
		System.out.println(collect2);
		
		
		//terminal operator
		//toarray();
		Stream<Integer> s = Stream.of(1,2,3,4,5);
		Object[]array =s.toArray();
		for(Object a:array) {
			System.out.print(a+ " ");
		}
		
		//count
		long count = s.count();
		System.out.println(count);
	}
}
