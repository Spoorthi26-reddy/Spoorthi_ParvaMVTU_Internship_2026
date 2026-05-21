package Function_in_java;

import java.util.Scanner;

public class task_reversenum {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter a number:");
		int n = sc.nextInt();
		int res = reverseNum(n);
		System.out.println(res);
	}
	public static int reverseNum (int n) {
		int reverse=0;
		while(n>0) {
			int digit = n%10;
			reverse=reverse*10+digit;
			n=n/10;
		}
		return reverse;
		
	}
	
}
