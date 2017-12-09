package org.Guava;

import com.google.common.net.InetAddresses;

public class IpAddressTest {

	public static void main(String[] args) {
		
		// Positive test cases
		String str1 = "172.16.254.1";
		String str2 = "2001:db8:0:1234:0:567:8:1";
		String str3 = "FE80:0000:0000:0000:0202:B3FF:FE1E:8329";
		
		System.out.println("str1 is valid : " + InetAddresses.isInetAddress(str1));
		System.out.println("str2 is valid : " + InetAddresses.isInetAddress(str2));
		System.out.println("str3 is valid : " + InetAddresses.isInetAddress(str3));
		
		// Negative test cases
		String str4 = "172.16.256.1";
		String str5 = "2001:db8:0:1234:0:567:8:1:0";
		System.out.println("str4 is valid : " + InetAddresses.isInetAddress(str4));
		System.out.println("str5 is valid : " + InetAddresses.isInetAddress(str5));
		
		
	} //end main
	
}
