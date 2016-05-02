package com.slickjava.rook.net;

import java.net.InetAddress;

import com.slickjava.rook.Server;
import com.slickjava.rook.net.packet.packets.net.N00Login;
import com.slickjava.rook.net.packet.packets.net.N01Disconnect;
import com.slickjava.rook.net.packet.packets.net.N02RequestEncryptionKey;
import com.slickjava.rook.net.packet.packets.net.N03BroadcastMessage;
import com.slickjava.rook.net.packet.packets.net.N04Message;
import com.slickjava.rook.player.Player;
import com.slickjava.rook.player.PlayerManager;
import com.slickjava.rook.player.kingdom.Kingdom;

public class NetPacketHandler {
	
	public void handleN00Login(N00Login packet, InetAddress ipAddress, MainServer server)
	{
		for(Player player : MainServer.activeConnections)
		{
			if(player.getUsername() == packet.getUsername())
			{
				player.setOnline(true);
				return;
			}
		}
		
		Kingdom kingdom = new Kingdom(packet.getUsername(), Server.getMap().getRandomX(), Server.getMap().getRandomY());
		Player player = new Player(packet.getUsername(), ipAddress, kingdom);
		MainServer.activeConnections.add(player);
		player.setOnline(true);
		server.broadcastMessage(player.getUsername() + " just connected!");
		System.out.println(player.getUsername() + " connected from " + ipAddress.getHostAddress());
		//TODO
	}
	
	public void handleN01Disconnect(N01Disconnect packet, MainServer server)
	{
		for(Player player : PlayerManager.players)
		{
			if(player.getUsername().equals(packet.getUsername()))
			{
				player.setOnline(false);
				MainServer.activeConnections.remove(player);
				System.out.println(player.getUsername() + " disconnected.");
				server.broadcastMessage(player.getUsername() + " just disconnected.");
				return;
			}
		}
		//TODO
	}
	
	public void handleN02RequestEncryptionKey(N02RequestEncryptionKey packet)
	{
		
	}
	
	public void handleN03BroadcastMessage(N03BroadcastMessage packet, MainServer server)
	{
		server.broadcastMessage(packet.getMessage());
		System.out.println("Broadcast: " + packet.getMessage());
	}
	
	public void handleN04Message(N04Message packet, MainServer server)
	{
		server.sendMessage(packet.getPlayerName(), packet.getMessage());
	}

}
