package org.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * int read() : read a character from character stream, return type is int, if nothing return -1.
 * int read(char cbuf[]) : read character cbuf length characters from character stream, if nothing return -1.
 * 
 * write(int c) write character c into output character stream
 * write(char cbuf[]) write characters from cbuf[] into character stream
 * write(String str) : write str into character stream
 * 
 * byte stream to char stream:
 * public String(byte[] bytes, String charsetName)
 * 
 * character stream to byte stream:
 * byte[] String.getBytes(String charsetName) 
 * charSetName is charEncoding (for example, ASCII or UTF-8)
 * 
 * 
 */

public class BufferedReaderExample {

	public static void main(String[] args) throws Exception {
		example1();
		example2();
		readFile("/Users/sxu/Desktop/example.sh");
	}

	private static void example1() throws Exception {
		File f = new File("/Users/sxu/Desktop/example.sh");
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis);
		char st = (char) isr.read();
		System.out.println(st);
	}

	private static void example2() throws Exception {
		File f = new File("/Users/sxu/Desktop/example.sh");
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		System.out.println(br.readLine());
	}
	
	private static void readFile(String fileName) throws Exception {
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	private static void example4() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		br.close();
	}

}
