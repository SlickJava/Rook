package com.slickjava.rook.net.packet;

public enum PacketType {

	INVALID("-1"), LOGIN("00"), DISCONNECT("01"), REQUEST_ENCRYPTION_KEY("02"), BROADCAST_MESSAGE("03"), MESSAGE("04"), RETURNED("99");
	
	private String packetID;
	
	private PacketType(String packetID)
	{
		this.packetID = packetID;
	}
	
	public String getPacketID()
	{
		return this.packetID;
	}
}
