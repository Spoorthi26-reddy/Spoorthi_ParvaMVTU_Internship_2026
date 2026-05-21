
package com.intro_collection_framework;

import java.util.ArrayList;
import java.util.List;

public class List_interface {
	public static void main(String[] args) {
		List l= new ArrayList();
		l.add(12);
		l.add(12);
		l.add(true);
		l.add(true);
		l.add("hello");
		System.out.println(l);
		System.out.println(l.get(2));
		System.out.println(l.size());
	}

}
