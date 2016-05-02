package com.slickjava.rook.net;

import com.slickjava.rook.net.packet.packets.N03BroadcastMessage;
import com.slickjava.rook.net.packet.packets.N04Message;

public class NetPacketHandler {
	
	public void handleN03BroadcastMessage(N03BroadcastMessage packet)
	{
		System.out.println(packet.getMessage());
	}
	
	public void handleN04Message(N04Message packet)
	{
		System.out.println(packet.getMessage());
	}

}
