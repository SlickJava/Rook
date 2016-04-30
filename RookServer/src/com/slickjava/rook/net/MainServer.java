package com.slickjava.rook.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.slickjava.rook.Server;
import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;
import com.slickjava.rook.net.packet.packets.net.N00Login;
import com.slickjava.rook.net.packet.packets.net.N01Disconnect;

public class MainServer {
	
	private CommandPacketHandler cpHandler;
	private NetPacketHandler npHandler;
	
	private DatagramSocket serverSocket;
	
	public MainServer()
	{
		cpHandler = new CommandPacketHandler();
		npHandler = new NetPacketHandler();
		this.createServer();
	}
	
	public void createServer()
	{
		try {
			this.serverSocket = new DatagramSocket(Server.port);
			this.listenForPackets();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listenForPackets()
	{
		try {
			while(true)
			{
				byte[] buf = new byte[1024];
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				serverSocket.receive(packet);
				
				this.parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void parsePacket(byte[] data, InetAddress clientAddress, int port)
	{
		Packet packet = null;
		PacketType packetType = packet.getTypeFromData(data);
		
		switch (packetType)
		{
		case INVALID:
			break;
		case LOGIN:
			packet = new N00Login(data);
			npHandler.handleN00Login((N00Login)packet);
		case DISCONNECT:
			packet = new N01Disconnect(data);
			npHandler.handleN01Disconnect((N01Disconnect)packet);
			
		}
	}

}
