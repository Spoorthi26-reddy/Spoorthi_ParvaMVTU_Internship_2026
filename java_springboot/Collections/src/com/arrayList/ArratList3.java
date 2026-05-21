package com.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArratList3 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(30);
		al.add(140);
		al.add(150);
		al.add(180);
		al.add(100);
		System.out.println(al);
		
		//for-loop(index based)
		for ( int i=0;i<al.size();i++) {
			
			System.out.println(al.get(i)+" ");
		}
		System.out.println();
		System.out.println("===============================================");
		
		//for-each(enhanced for loop)
		for(int ele :al) {
			System.out.println(ele+" ");
		}
		System.out.println();
		System.out.println("================================================");
		
		
		//for each
		al.forEach((ele)-> System.out.println(ele+" "));
		
		System.out.println();
		System.out.println("================================================");
		
		
	//iterator-unidirectional (forward)
		Iterator<Integer> itr =al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		System.out.println();
		System.out.println("===================================================");
		
		//ListIterator - bidirectional(both forward and backward)
		ListIterator<Integer> list=al.listIterator();
		
		while(list.hasNext()) {
			System.out.println(list.next()+" ");
		}
		
	}
}
