package com.slickjava.rook.net.packet.packets;

import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;

public class N03BroadcastMessage extends Packet{

	private String message;
	
	public N03BroadcastMessage(byte[] data)
	{
		super(PacketType.BROADCAST_MESSAGE);
		this.setData(data);
	}
	
	public N03BroadcastMessage(String message) {
		super(PacketType.BROADCAST_MESSAGE);
		// TODO Auto-generated constructor stub
		this.message = message;
		this.setData(this.createData());
	}

	@Override
	protected byte[] createData() {
		return message.getBytes();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
