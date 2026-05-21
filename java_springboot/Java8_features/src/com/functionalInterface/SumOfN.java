package com.functionalInterface;

import java.util.function.Function;

public class SumOfN {
	public static void main(String[] args) {
		Function<Integer,Integer> fun = (num)->{
			int res =0;
			for(int i=0;i<=num;i++) {
				res+=i;
			}
			return res;
		};
		System.out.println(fun.apply(5));
	}
}
