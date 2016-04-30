package com.slickjava.rook.net;

import java.net.DatagramSocket;
import java.net.InetAddress;

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
	}
	
	public void listenForClients()
	{
		while(true)
		{
			
		}
	}
	
	public void parsePacket(byte[] data, InetAddress clientAddress, int port)
	{
		String parsedMessage = new String(data).trim();
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
