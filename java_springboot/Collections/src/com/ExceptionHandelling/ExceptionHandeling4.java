package com.ExceptionHandelling;

public class ExceptionHandeling4 {
		public static void main(String[] args) {
			System.out.println("start of program");
			
		     try {
		            System.out.println("res: " + (10 / 0));
		        } catch (ArithmeticException e) {
		            System.out.println("Exception caught: " + e);
		        }
		        
		        System.out.println("end of program");
		    }

}
