package com.arrayList;

import java.util.ArrayList;

public class ArrayList2 {
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(34);
		arr1.add(34);
		arr1.add(34);
		System.out.println(arr1);
		int age=arr1.get(0);
		
		int num=30;
		//Integer num2 = num; //auto boxing
		Integer num2 = Integer.valueOf(num);
		
		//int num3 = num2; //un boxing
		int num3= num2.intValue();
		
		Byte b=30;
		byte b1=b.byteValue();
		
		
	}
}
