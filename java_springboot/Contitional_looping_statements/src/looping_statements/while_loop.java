package looping_statements;

import java.util.Scanner;

public class while_loop {
	public static void main(String[] args) {
		//we use while loop if we dont know the no. of iteration and condition check happens before execution
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int count = sc.nextInt();
		
		int i=0;
		while(i<=count) {
			System.out.println("value:" +i);
			i++;
		}
	}

}
