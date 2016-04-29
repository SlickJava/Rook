package com.slickjava.rook.net.packet;

public class Packet {

	private PacketType type;
	
	public Packet(PacketType type)
	{
		this.type = type;
	}
	
	

	public PacketType getType() {
		return type;
	}
	
	
	
}
