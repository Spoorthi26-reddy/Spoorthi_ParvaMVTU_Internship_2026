package Function_in_java;

import java.util.Scanner;

public class factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num:");
		int n = sc.nextInt();
		printFactorial(n);
		
	}
	
	public static void printFactorial(int n) {
		int factorial=1;
		for(int i=1;i<=n;i++) {
			factorial=factorial*i;
		}
		System.out.println(factorial);
		return;
	}
}
