package Scanner;

import java.util.Scanner;
public class scanner1 {
	public static void main(String[] args) {
		/* sacnner class for different data types
		 * sc.nextBoolean();
		 * sc.nextShort();
		 * sc.nextInt(); = to store numbers
		 * sc.nextLong(); = to store long digits like ph numbers
		 * sc.nectFloat();  = to store floating nunmbers
		 * sc.nextDouble();  = to store decimal numbers
		 * sc.next(); = it will print upto spaces
		 * sc.nextLine(); = to store the whole string including spaces
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your name:");
		String str = sc.nextLine();
		System.out.println("your name is : "+str);
		
		
		System.out.println("Enter your ph number:");
		long n = sc.nextLong();
		System.out.println("your number is: "+n);
		
		System.out.println("enter your gender:");
		char gender = sc.next().charAt(0);
		System.out.println("your gender is:" +gender);
		
		
		System.out.println("enter your maths marks");
		int m = sc.nextInt();
		System.out.println("your marks is:" +m);
		
		
		System.out.println("enter your percentage");
		float p = sc.nextFloat();
		System.out.println("your percent is:" +p);
		
		sc.close();
		
			
		
	}
	

}
