package conditional_statements;

import java.util.Scanner;

public class task_ifelse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter marks:");
		int marks = sc.nextInt();
		
		if( marks>=90 && marks<=100) {
			System.out.println("Grade:A");
			System.out.println("Grade Description : Excellent");
		}else if(marks>=75 && marks<=89) {
			System.out.println("Grade:B");
			System.out.println("Grade Description : Good");
		}else if(marks>=60 && marks<=74) {
			System.out.println("Grade:C");
			System.out.println("Grade Description : Average");
		}else if(marks>=50 && marks<=59) {
			System.out.println("Grade:D");
			System.out.println("Grade Description : Pass");
		}else if(marks<=50) {
			System.out.println("Grade Description : Fail");
		}else {
			System.out.println("fail");
		}
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("enter your grade(A,B,C,D,F):");
		char grade = sc.next().toString().charAt(0);
		
		System.out.println("Grade Description: ");
		switch (grade) {
		case 'A':
			System.out.println("Excellent");
			break;
		case 'B':
			System.out.println("Good");
			break;
		case 'C':
			System.out.println("Average");
			break;
		case 'D':
			System.out.println("Pass");
			break;
		case 'F':
			System.out.println("Fail");
			break;
		default:System.out.println("Invalid grade entered");
			break;
			
		}
		sc.close();
	}

}
