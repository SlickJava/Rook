package com.slickjava.rook.net;

import java.net.InetAddress;

import com.slickjava.rook.Server;
import com.slickjava.rook.net.packet.packets.net.N00Login;
import com.slickjava.rook.net.packet.packets.net.N01Disconnect;
import com.slickjava.rook.net.packet.packets.net.N02RequestEncryptionKey;
import com.slickjava.rook.net.packet.packets.net.N03BroadcastMessage;
import com.slickjava.rook.player.Player;
import com.slickjava.rook.player.PlayerManager;
import com.slickjava.rook.player.kingdom.Kingdom;

public class NetPacketHandler {
	
	public void handleN00Login(N00Login packet, InetAddress ipAddress)
	{
		for(Player player : PlayerManager.players)
		{
			if(player.getUsername() == packet.getUsername())
			{
				player.setOnline(true);
				return;
			}
		}
		
		Kingdom kingdom = new Kingdom(packet.getUsername(), Server.gameMap.getRandomX(), Server.gameMap.getRandomY());
		Player player = new Player(packet.getUsername(), ipAddress, kingdom);
		MainServer.activeConnections.add(player);
		player.setOnline(true);
		
		System.out.println(player.getUsername() + " connected from " + ipAddress.getHostAddress());
		//TODO
	}
	
	public void handleN01Disconnect(N01Disconnect packet)
	{
		for(Player player : MainServer.activeConnections)
		{
			if(player.getUsername().equals(packet.getUsername()))
			{
				player.setOnline(false);
				MainServer.activeConnections.remove(player);
				System.out.println(player.getUsername() + " disconnected.");
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
		server.echoData(packet.getMessage().getBytes());
	}

}
