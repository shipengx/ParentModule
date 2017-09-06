package org.ChatServer;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {

	public static void main(String args[]) throws Exception {
		Socket sock = new Socket("127.0.0.1", 9090);
		String message1 = "Accept Best Wishes, Server ";

		OutputStream ostream = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(ostream);
		dos.writeBytes(message1);
		dos.close();
		ostream.close();
		sock.close();
	}
}
