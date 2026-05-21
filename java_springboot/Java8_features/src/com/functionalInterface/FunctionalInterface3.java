package com.functionalInterface;
//@FunctionalInterface
interface EvenOrOdd{
	boolean even_odd(int a);
}

public class FunctionalInterface3 {
	public static void main(String[] args) {
		EvenOrOdd num= a->a%2==0;
			if(num.even_odd(11)) {
				System.out.println("even");
			}else {
				System.out.println("odd");
			}
		
	}

}
