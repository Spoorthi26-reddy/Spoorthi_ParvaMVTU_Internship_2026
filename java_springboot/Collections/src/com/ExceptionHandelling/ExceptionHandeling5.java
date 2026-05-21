package com.ExceptionHandelling;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionHandeling5 {
		public static void main(String[] args) throws FileNotFoundException {
			PrintWriter pw=null;
		
		try {
			System.out.println("oprning file");
			pw=new PrintWriter("world.txt");
			pw.write("Hello World");
			System.out.println("Completed1");
			
		} finally {
			System.out.println("Closing file");
			if(pw !=null);
			pw.close();
		}
		
		String str=null;
		System.out.println(str.charAt(1));
	}

}
