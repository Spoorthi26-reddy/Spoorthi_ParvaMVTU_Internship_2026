package AllOperators;

public class ArithmeticOperators {
	public static void main(String[] args) {
		/*unary operator : pre-increment(a++,a--) and post-increment(++a,--a)
		 * binary operator : addition, subtraction, multiplication, division etc
		 * +,-,*,/,%
		 */
		
		//pre-increment
		int a1=10;
		int b1=0;
		b1=a1++;
		System.out.println(a1);
		System.out.println(b1);
		
		//post-increment
		int c=10;
		int d=0;
		d=++c;
		System.out.println("value is:" +c);
		System.out.println("value is :" +d);
		
		//pre-decrement
		int e=10;
		int f=0;
		f=--e;
		System.out.println(e);
		System.out.println(f);
		
		//post-decrement
		int g=10;
		int h=0;
		h=g++;
		System.out.println(g);
		System.out.println(h);
		
		
		int a = 20;
		int b = 2;
		int res1 = a+b;
		int res2 = a-b;
		int res3 = a*b;
		int res4 = a/b;
		System.out.println("addition of two numbers:" +res1);
		System.out.println("subtraction of two numbers:" +res2);
		System.out.println("multiplication of two numbers:" +res3);
		System.out.println("division of two numbers:" +res4);
	}
	

}
