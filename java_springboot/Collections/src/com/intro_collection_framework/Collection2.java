package com.intro_collection_framework;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {
	public static void main(String[] args) {
		Collection c1 =new ArrayList();         //upcasting //no type safety and need to typecast - to overcome this we have generics in java
		c1.add("spoorthi");
		c1.add(12);
		c1.add(true);
		System.out.println(c1);
		
		Collection c2 =new ArrayList();
		c2.add("hello");
		c1.addAll(c2);
		System.out.println(c1);
		
	}
}
