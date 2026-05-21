package com.lambdaFunction;

import java.util.Arrays;
import java.util.List;

public class LambdaFunction {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5); 
		numbers.forEach(n->System.out.println(numbers));
	}
}
