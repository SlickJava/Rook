package com.slickjava.rook.net.packet;

public enum PacketType {

	INVALID(-1), LOGIN(00), DISCONNECT(01);
	
	private int packetID;
	
	private PacketType(int packetID)
	{
		this.packetID = packetID;
	}
	
	public int getPacketID()
	{
		return this.packetID;
	}
}
