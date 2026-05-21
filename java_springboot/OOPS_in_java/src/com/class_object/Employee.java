package com.class_object;

public class Employee {
	String emp_name;
	int emp_id;
	String emp_mail;
	
	public static String isWorking() {
		return "yes he is working";
	}
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.emp_name ="Spoorthi";
		emp.emp_id=153;
		emp.emp_mail="spoorthireddyy26@gmail.com";
		String res = Employee.isWorking();
		
		System.out.println("name:" +emp.emp_name);
		System.out.println("id:" +emp.emp_id);
		System.out.println("mail:" +emp.emp_mail);
		System.out.println(res);
		
		Employee emp1 = new Employee();
		emp1.emp_name ="Spoorthi";
		emp1.emp_id=153;
		emp1.emp_mail="spoorthireddyy26@gmail.com";
		String res1 = Employee.isWorking();
		
		System.out.println("name:" +emp1.emp_name);
		System.out.println("id:" +emp1.emp_id);
		System.out.println("mail:" +emp1.emp_mail);
		System.out.println(res);
		
	}

}
