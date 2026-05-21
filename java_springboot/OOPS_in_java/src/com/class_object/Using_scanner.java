package com.class_object;

import java.util.Scanner;


	public class Using_scanner{
		String name;
		int USN;
		long ph_num;
		int marks;
		
		public void isPresent() {
			System.out.println("yes she is present");
		}
		public static void main(String[] args) {
			System.out.println("enter the student1 details");
			Using_scanner stud = new Using_scanner();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter student1 name");
			stud.name=sc.nextLine();
			
			System.out.println("enter student1 USN");
			stud.USN = sc.nextInt();
			
			System.out.println("enter student1 ph_num");
			stud.ph_num=sc.nextLong();
			
			System.out.println("enter student1 marks");
			stud.marks = sc.nextInt();
			
			System.out.println("Name:" +stud.name);
			System.out.println("USN:" +stud.USN);
			System.out.println("ph_num:" +stud.ph_num);
			System.out.println("marks:" +stud.marks);
			stud.isPresent();
			
			
		}	
}

