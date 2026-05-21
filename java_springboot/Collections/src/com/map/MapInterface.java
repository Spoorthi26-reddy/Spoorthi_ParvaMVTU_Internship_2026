package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapInterface {
	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(1, "hello");
		map.put(2, "world");
		map.put(3, "hii");
		map.put(4, "hello");
		        System.out.println(map);

		       
		        map.forEach((k, v) -> System.out.println(k + " -> " + v));

		       
		        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

		        for (Map.Entry<Integer, String> entry : entrySet) {
		            System.out.println(entry.getKey() + " => " + entry.getValue());
		        }
		    }
	}

