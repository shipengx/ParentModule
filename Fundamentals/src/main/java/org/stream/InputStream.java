package org.stream;

import java.io.File;
import java.io.FileInputStream;

/*
 * int read() returns an integer from 0 - 255, if nothing return -1
 * int read(byte b[]) returns data into byte array b, if nothing return -1
 * InputStream & OutputStream ===>>> byte stream.
 * 
 * Reader & Writer ====> character stream
 * 
 * 
 */

public class InputStream {

	public static void main(String[] args) throws Exception {
		//example1();
		example2();
	}

	private static void example1() throws Exception {
		File file = new File("/Users/sxu/Desktop/example.sh");
		FileInputStream fileInputStream = new FileInputStream(file);
		for (int i = 0; i < file.length(); i++) {
			char tmp = (char) fileInputStream.read();
			System.out.println(tmp);
		}
		fileInputStream.close();
	}

	private static void example2() throws Exception {
		File file = new File("/Users/sxu/Desktop/example.sh");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		fileInputStream.read(b);
		for (int i = 0; i < file.length(); i++) {
			System.out.println((char) b[i]);
		}
		fileInputStream.close();
	}

}
