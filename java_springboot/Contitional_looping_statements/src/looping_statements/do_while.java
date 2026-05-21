package looping_statements;

import java.util.Scanner;

public class do_while {
	public static void main(String[] args) {
		//even With the false condition loop will execute atleast one time
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int count = sc.nextInt();
		
		int i=0;
		do {
			System.out.println("value:" +i);
			i++;
		}while(i<=count);
	}

}
