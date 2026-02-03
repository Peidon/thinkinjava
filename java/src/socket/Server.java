package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serversocket = new ServerSocket(12345);
		Socket socket = serversocket.accept();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						socket.getInputStream()));
		String line = in.readLine();
		System.out.println(line);
		serversocket.close();
		socket.close();
	}
}
