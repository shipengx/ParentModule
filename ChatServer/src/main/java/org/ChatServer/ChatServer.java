package org.ChatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String args[]) throws Exception {
		ServerSocket sersock = new ServerSocket(9090);
		System.out.println("server is ready"); // message to know the server is
												// running

		Socket sock = sersock.accept();

		InputStream in = sock.getInputStream();
		//DataInputStream dstream = new DataInputStream(istream);
		BufferedReader d = new BufferedReader(new InputStreamReader(in));

		boolean done = false;
		while (!done) {
			try {
				String line = d.readLine();
				if (line == null) break;
				System.out.println(line);
				done = line.equals(".bye");
			} catch (IOException ioe) {
				done = true;
			}
		}

		d.close();
		in.close();
		sock.close();
		sersock.close();
		System.out.println("server is shut down.");
	}
}