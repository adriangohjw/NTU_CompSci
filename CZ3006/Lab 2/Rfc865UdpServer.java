package cz3006_lab2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Rfc865UdpServer {

	@SuppressWarnings("resource")
	public static void main(String[] argv) {
		
		 // 1. Open UDP socket at well-known port
		 System.out.println("Server is running...");
		 DatagramSocket socket = null;
		 byte[] buffer = new byte[512];
		 
		 try {
			 socket = new DatagramSocket();
		 } catch (SocketException e) {}
	 
		 while (true) {
			 try {
				 
				 // 2. Listen for UDP request from client
				 DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				 socket.receive(request);
				 
				 InetAddress address = request.getAddress();
				 int port = request.getPort();
				 
				 // 3. Send UDP reply to client
				 DatagramPacket reply = new DatagramPacket(buffer, buffer.length, address, port);
				 socket.send(reply);
				 
			 } catch (IOException e) {}
		 }
	 }
}
