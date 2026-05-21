package looping_statements;

public class for_loop {
	public static void main(String[] args) {
		/*
		 * we should use for loop when we know the no. of iteration.
		 * syntax:
		 * for(initialization , condition , updation){
		 *    //code
	        }
		 */
		int num = 5;
		for( int i =1; i<=10;i++) {
			System.out.println(num +"*" +i+ "=" +(num*i) );
		}
	}

}
