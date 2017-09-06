package com.ChatServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GossipServer {

	public static void main(String[] args) throws Exception {
		ServerSocket sersock = new ServerSocket(9090);
		System.out.println("Server  ready for chatting");
		Socket sock = sersock.accept();
		// reading from keyboard (keyRead object)
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		// sending to client (pwrite object)
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);

		// receiving from server ( receiveRead object)
		InputStream istream = sock.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

		String receiveMessage, sendMessage;
		boolean done = false;
		while (!done) {
			if ((receiveMessage = receiveRead.readLine()) != null) {
				System.out.println(receiveMessage);
				if (receiveMessage.equals("bye"))
					break;
			}
			sendMessage = keyRead.readLine();
			pwrite.println(sendMessage);
			pwrite.flush();
		}

		sersock.close();
		pwrite.close();
		istream.close();

	}
}