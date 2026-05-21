package Function_in_java;

import java.util.Scanner;

public class task_SumOfDigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the numbers:");
		int n= sc.nextInt();
		int res=SumOfDigits(n);
		System.out.println(res);
		
	}
	public static int SumOfDigits(int n) {
		int sum=0;
		while(n>0) {
			int digit = n%10;
			sum = sum+digit;
			n=n/10;
		}
		return sum;
	}
}
