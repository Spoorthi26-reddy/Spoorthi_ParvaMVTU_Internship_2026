package com.map;


import java.util.Map;
import java.util.TreeMap;

public class MapInterface2 {
	public static void main(String[] args) {
		Map<Integer, String> map=new TreeMap<Integer, String>();
		map.put(1, "hello");
		map.put(2, "world");
		map.put(3, "hii");
		map.put(4, "hello");
		        System.out.println(map);
	}
}
