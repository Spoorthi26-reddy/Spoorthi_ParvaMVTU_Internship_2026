package typecasting_java;

import java.util.Scanner;

public class task_typecasting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter integer number:");
		int marks = sc.nextInt();
		
		double marks1 = marks;
		System.out.println("After Implicit Casting(int to double):" +marks1);
		
		int marks2 = (int)marks1;
		System.out.println("After Explicit casting(double to int):" +marks2);
		
		sc.close();
	}
}
