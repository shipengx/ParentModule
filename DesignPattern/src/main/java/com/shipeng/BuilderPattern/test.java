package com.shipeng.BuilderPattern;

public class test {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println("str1 and str2 are equal: " + str1.equals(str2));
		System.out.println("str1 and str2 are equal: " + (str1 == str2));
		
		String str3 = new String("abc");
		String str4 = new String("abc");
		System.out.println("str3 and str4 are equal: " + str3.equals(str4));
		System.out.println("str3 and str4 are equal: " + (str3 == str4));
	}
	
}
