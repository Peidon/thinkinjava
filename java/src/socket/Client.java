package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket(InetAddress.getByName("localhost"),12345);
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									s.getOutputStream())));
			out.println("Hello");
			out.flush();
			out.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
