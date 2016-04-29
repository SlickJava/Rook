package com.slickjava.rook.net.packet;

public class Packet {

	private PacketType type;
	private byte[] data;
	
	public Packet(PacketType type, byte[] data)
	{
		this.type = type;
		this.data = data;
	}
	
	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}


	public PacketType getType() {
		return type;
	}
	
	
	
}
