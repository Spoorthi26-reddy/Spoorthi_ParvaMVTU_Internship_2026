package com.arrays;

import java.util.Arrays;

public class Multi_store_Arrays {
	 public static void main(String[] args) {
		/*
		 * in java we can store multiple data values in an array.
		 * it is possible using object class
		 */
		 
		 Object arr[]=new Object[4];
		 arr[0]=12;
		 arr[1]="sparrow";
		 arr[2]='f';
		 arr[3]=29.3;
		 System.out.println("Array:" +Arrays.toString(arr));
	}
}
