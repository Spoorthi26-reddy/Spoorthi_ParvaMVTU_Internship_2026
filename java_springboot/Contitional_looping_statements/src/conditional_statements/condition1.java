package conditional_statements;

import java.util.Scanner;

public class condition1 {
	public static void main(String[] args) {
		/*
		 * conditional statements
		 * 1. if
		 * 2.if-else
		 * 3.else-if
		 * 4.switch
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your age:");
		int age = sc.nextInt();
		if(age>18) {
			System.out.println("eligible to vote");
		}else {
			System.out.println("not eligible");
			sc.close();
		}
	}
}
