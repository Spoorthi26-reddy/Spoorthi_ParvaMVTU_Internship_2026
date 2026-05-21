package com.functionalInterface;

import java.util.function.Predicate;

public class PrimeNum_predicate {
	public static void main(String[] args) {
		Predicate<Integer> pri=num->{
			if(num<=1) 
			return false;
			for(int i=2;i<=num/2;i++) {
				if(num%i ==0)
					return false;
			}
			return true;
		};
		boolean res = pri.test(11);
		if(res)System.out.println("prime");
		else System.out.println("not prime");
	}
	
}
