package Function_in_java;

public class Function1 {
	public static void main(String[] args) {
		/*
		 * Functions : block of code used to perform a particular task
		 * two types:
		 * 1. built-in functions = nextInt(),println()
		 * 2. user defined functions 
		 *  syntax:
		 *  access_modifier return_type fun_name(para){
		 *   //code
		 *   }
		 */
		
		Function1 fun =new Function1();
		fun.add(10,20);
	}
	public void add(int a, int b) {
		System.out.println("res:" +(a+b));
	}

}
