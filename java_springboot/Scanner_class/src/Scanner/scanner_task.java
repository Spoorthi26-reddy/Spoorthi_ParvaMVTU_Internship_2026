package Scanner;

import java.util.Scanner;

public class scanner_task {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter student name:");
		String str = sc.nextLine();
		
		System.out.println("Enter the USN:");
		String n = sc.nextLine();
		
		System.out.println("Enter Branch:");
		String str1 = sc.nextLine();
		
		System.out.println("Enter Percentage:");
		double p = sc.nextDouble();
		
		
		System.out.println("---------STUDENT DETAILS--------");
		System.out.println("Name: " +str);
		System.out.println("USN: " +n);
		System.out.println("Branch: " +str1);
		System.out.println("Percentage: " +p);
		
		sc.close();
		
		
	}
}
