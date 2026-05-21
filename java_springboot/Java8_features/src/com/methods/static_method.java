package com.methods;

import java.util.Arrays;
import java.util.List;

public class static_method {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c");
		list.forEach(System.out::println);
	}
}
