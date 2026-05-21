package Function_in_java;

import java.util.Scanner;

public class task_countdigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the numbers");
		int n= sc.nextInt();
		int res = countDigits(n);
		System.out.println(res);
	}
	
	public static int countDigits (int n) {
		int count=0;
		while(n>0) {
			n=n/10;
			count++;
		}
		return count;
	}
}
