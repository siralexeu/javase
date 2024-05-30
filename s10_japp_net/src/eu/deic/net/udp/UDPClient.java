package eu.deic.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) {
		try(DatagramSocket clientSocket = new DatagramSocket();){
			byte[] buf2Snd = " What date & time is it?".getBytes();
			
			InetAddress addrDst = InetAddress.getByName(args[0]); 
			int portDst = Integer.parseInt(args[1]);
			DatagramPacket packet2Snd = new DatagramPacket(buf2Snd, buf2Snd.length, addrDst, portDst);
			clientSocket.send(packet2Snd);
			
			byte[] bufResp = new byte[256];
			DatagramPacket packetResp = new DatagramPacket(bufResp, bufResp.length);
			clientSocket.receive(packetResp);
			String strRecv = new String(packetResp.getData());
			System.out.println("Msg from server 2 me/client -> " + strRecv );
			//clientSocket.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}//end main method

}//end main class
