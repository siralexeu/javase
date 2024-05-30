package eu.deic.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPServer {

	public static void main(String[] args) {
		byte[] bufRecv = null; byte[] bufResp = null;
		try(DatagramSocket sockServer = new DatagramSocket(7778)) {
			System.out.println("UDP Server DEIC/DICE binds on port 7778!");
			
			while(true) {
				bufRecv = new byte[256];
				DatagramPacket packetRecv = new DatagramPacket(bufRecv, bufRecv.length);
				sockServer.receive(packetRecv);
				String strRecv = new String(packetRecv.getData());
				System.out.println("Client -> " + strRecv );
				//System.out.println("Client -> " + new String(bufRecv) );
				
				String strResp = null;
				if("What date & time is it?".equalsIgnoreCase(strRecv)) {
					strResp = new Date().toString();
				} else {
					strResp = "I am ChatGPT 0.1 and I am stupid.. I dont understand your question!";
				}
				bufResp = strResp.getBytes();
				
				InetAddress addr4Resp = packetRecv.getAddress();
				int port4Resp = packetRecv.getPort();
				DatagramPacket packetResp = new DatagramPacket(bufResp, bufResp.length, addr4Resp, port4Resp);
				sockServer.send(packetResp);			
			}//end while
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
	}//end main method

}// end main class
