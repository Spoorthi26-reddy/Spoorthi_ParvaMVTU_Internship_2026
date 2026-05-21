package conditional_statements;

import java.util.Scanner;

public class switch_case {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day no:");
		int value = sc.nextInt();
		
//		switch(value) {
//		case 1:
//			System.out.println("mon");
//			break;
//		case 2:
//			System.out.println("tue");
//			break;
//		default:
//			System.out.println("invalid");
//		}
		
		String typeOfDay = switch (value) {
		case 1,2,3,4,5 -> "weekday";
		case 6,7 -> "weekend";
		default -> "invalid day";
		};
		System.out.println("Res:" +typeOfDay);
	}

}
