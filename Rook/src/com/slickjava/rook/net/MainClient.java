package com.slickjava.rook.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.slickjava.rook.Client;
import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;
import com.slickjava.rook.net.packet.packets.N00Login;
import com.slickjava.rook.net.packet.packets.N03BroadcastMessage;
import com.slickjava.rook.net.packet.packets.N04Message;
import com.slickjava.rook.security.Encrypt;

public class MainClient {
	
	private DatagramSocket clientSocket;
	private InetAddress hostAddress;
	private NetPacketHandler npHandler;
	private Encrypt encryption;
	
	public MainClient(String host)
	{
		npHandler = new NetPacketHandler();
		
		try {
			clientSocket = new DatagramSocket();
			hostAddress = InetAddress.getByName(host);
			encryption = new Encrypt();
			this.listenForPackets();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login(String username, String password)
	{
		N00Login packetl = new N00Login(username, password);
		packetl.sendData(clientSocket, hostAddress, Client.getPort(), encryption);
	}
	
	public void listenForPackets()
	{
		System.out.println("Listening for packets...");
		System.out.println("Connecting to server...");
		this.login("test", "test");
		while(true)
		{
			try {
				byte[] buf = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				clientSocket.receive(packet);
				System.out.println(new String(packet.getData()));
				
		        String msg  = (this.encryption.decrypt(new String(packet.getData())));
		        if(msg != null)  {
		        	byte[] decrypted = msg.getBytes();
					this.parsePacket(decrypted, packet.getAddress(), packet.getPort());
		        } else {
		        	System.out.println("Invalid encryption key from " + packet.getAddress());
		        }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void parsePacket(byte[] data, InetAddress clientAddress, int port)
	{
		Packet packet = null;
		PacketType packetType = Packet.getTypeFromData(data);

		switch (packetType) {
		case INVALID:
			break;
		case BROADCAST_MESSAGE:
			packet = new N03BroadcastMessage(data);
			npHandler.handleN03BroadcastMessage((N03BroadcastMessage)packet);
			break;
		case MESSAGE:
			packet = new N04Message(data);
			npHandler.handleN04Message((N04Message) packet);
			break;
		case RETURNED:
			String message = new String(data);
			System.out.println(message);
			message.substring(2);
			System.out.println(message);
			String split[] = message.split(":");
			String packetID = split[0];
			String locationReturned = split[1];
			
			for(PacketType type : PacketType.values())
			{
				if(type.getPacketID().equals(packetID))
				{
					if(type.getPacketID().equals(PacketType.LOGIN))
					{
						System.out.println("Connected to " + locationReturned);
					}
				}
			}
			break;
		default:
			break;
		}
	}
	

}
