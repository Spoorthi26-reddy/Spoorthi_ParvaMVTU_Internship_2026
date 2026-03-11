package AllOperators;

public class RelationalOperators {
public static void main(String[] args) {
	/*Relational operators - the output will be in boolean format(true/false)
	 * == : equalto
	 * != : not equalto
	 * > : greater than
	 * < :less than
	 * >= :greater than or equalto
	 * <= :lessthan or equalto
	 */
	int a = 20;
    int b = 10;

    boolean res1 = a == b;
    boolean res2 = a != b;
    boolean res3 = a > b;
    boolean res4 = a < b;
    boolean res5 = a >= b;
    boolean res6 = a <= b;

    System.out.println("a == b : " + res1);
    System.out.println("a != b : " + res2);
    System.out.println("a > b : " + res3);
    System.out.println("a < b : " + res4);
    System.out.println("a >= b : " + res5);
    System.out.println("a <= b : " + res6);
}
}
