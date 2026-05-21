package com.ExceptionHandelling;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionHandelling2 {
	public static void main(String[] args) throws FileNotFoundException {
			
			//1st way
			try {
				PrintWriter pw=new PrintWriter("hello.txt");
				pw.write("Hello World");
				System.out.println("Completed");
				pw.close();
				
				//3ways
			}catch  (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println(e);
			}
			
			//2nd way
			PrintWriter pw=new PrintWriter("world.txt");
			pw.write("Hello world");
			System.out.println("Completed");
			pw.close();
			
		}

}

