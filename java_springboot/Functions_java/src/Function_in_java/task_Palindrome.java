package Function_in_java;

import java.util.Scanner;

public class task_Palindrome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the num:");
		int n = sc.nextInt();
		
		if(isPalindrome(n)) {
			System.out.println("palindrome");
		}else {
			System.out.println("not palindrome");
		}
	}
	public static boolean isPalindrome(int n) {
		int original=n;
		int reverse=0;
		while(n>0) {
			int digit=n%10;
			reverse = reverse *10+digit;
			n=n/10;
		}
		return original == reverse;
	}
}
