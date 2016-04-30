package com.slickjava.rook.net;

import com.slickjava.rook.net.packet.packets.net.N00Login;
import com.slickjava.rook.net.packet.packets.net.N01Disconnect;
import com.slickjava.rook.player.Player;
import com.slickjava.rook.player.PlayerManager;

public class NetPacketHandler {
	
	public void handleN00Login(N00Login packet)
	{
		for(Player player : PlayerManager.players)
		{
			if(player.getUsername() == packet.getUsername())
			{
				return;
			}
		}
		
		//TODO
	}
	
	public void handleN01Disconnect(N01Disconnect packet)
	{
		//TODO
	}

}
