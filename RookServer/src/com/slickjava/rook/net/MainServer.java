package com.slickjava.rook.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import com.slickjava.rook.Server;
import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;
import com.slickjava.rook.net.packet.packets.net.N00Login;
import com.slickjava.rook.net.packet.packets.net.N01Disconnect;
import com.slickjava.rook.net.packet.packets.net.N02RequestEncryptionKey;
import com.slickjava.rook.net.packet.packets.net.N03BroadcastMessage;
import com.slickjava.rook.player.Player;
import com.slickjava.rook.security.Encrypt;

public class MainServer {
	
	private CommandPacketHandler cpHandler;
	private NetPacketHandler npHandler;
	private Encrypt encryption;
	private DatagramSocket serverSocket;
	
	public static ArrayList<Player> activeConnections = new ArrayList<Player>();
	
	public MainServer()
	{
		cpHandler = new CommandPacketHandler();
		npHandler = new NetPacketHandler();
		encryption = new Encrypt();
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
			System.out.println("Listening for clients.. ");
			while(true)
			{
			
				byte[] buf = new byte[1024];
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				serverSocket.receive(packet);
				
		        String msg  = (this.encryption.decrypt(new String(packet.getData())));
		        if(msg != null)  {
		        	byte[] decrypted = msg.getBytes();
					this.parsePacket(decrypted, packet.getAddress(), packet.getPort());
		        } else {
		        	System.out.println("Invalid encryption key from " + packet.getAddress());
		        }
		        
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void parsePacket(byte[] data, InetAddress clientAddress, int port)
	{
		Packet packet = null;
		PacketType packetType = Packet.getTypeFromData(data);

		switch (packetType) {
		
		case INVALID:
			break;
		case LOGIN:
			packet = new N00Login(data);
			npHandler.handleN00Login((N00Login)packet, clientAddress);
			break;
		case DISCONNECT:
			packet = new N01Disconnect(data);
			npHandler.handleN01Disconnect((N01Disconnect)packet);
			break;
		case REQUEST_ENCRYPTION_KEY:
			packet = new N02RequestEncryptionKey(data);
			npHandler.handleN02RequestEncryptionKey((N02RequestEncryptionKey)packet);
			break;
		case BROADCAST_MESSAGE:
			packet = new N03BroadcastMessage(data);
			npHandler.handleN03BroadcastMessage((N03BroadcastMessage)packet, this);
			break;
		}
	}
	
	public void sendData(byte[] data, InetAddress address, int port)
	{
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        try {
            this.serverSocket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void echoData(byte[] data)
	{
		for(Player p : MainServer.activeConnections)
		{
			this.sendData(data, p.getAddress(), Server.port);
		}
	}

}
