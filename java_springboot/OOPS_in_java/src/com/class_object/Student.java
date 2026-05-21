package com.class_object;

public class Student {
	String name;
	int USN;
	long ph_num;
	int marks;
	
	public void isPresent() {
		System.out.println("yes she is present");
	}
	public static void main(String[] args) {
	Student stud = new Student();
	stud.name ="Spoorthi";
	stud.USN = 153;
	stud.ph_num = 938947847;
	stud.marks=93;
	
	System.out.println("Name:" +stud.name);
	System.out.println("USN:" +stud.USN);
	System.out.println("ph_num:" +stud.ph_num);
	System.out.println("marks:" +stud.marks);
	stud.isPresent();
	
	Student stud1 = new Student();
	stud1.name ="Sony";
	stud1.USN = 163;
	stud1.ph_num = 938947847;
	stud1.marks=91;
	
	System.out.println("Name:" +stud1.name);
	System.out.println("USN:" +stud1.USN);
	System.out.println("ph_num:" +stud1.ph_num);
	System.out.println("marks:" +stud1.marks);
	stud.isPresent();
}
}