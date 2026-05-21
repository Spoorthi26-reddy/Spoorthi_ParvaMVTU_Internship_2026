package com.arrays;

import java.util.Scanner;

public class Search_in_matrix {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter rows");
		int rows=sc.nextInt();
		System.out.println("enter columns");
		int columns=sc.nextInt();
		
		int [][] numbers= new int [rows][columns];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				 numbers[i][j]=sc.nextInt();
			}
		}
		System.out.println("enter number u hv to find");
		int x =sc.nextInt();
		System.out.println("you entered"+ x);
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				if (numbers[i][j]==x) {
					System.out.println("found at index: (" + i + "," + j + ")");
				}
				
			}
			}
		
		
		
	}
}
