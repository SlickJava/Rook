package com.slickjava.rook.net.packet.packets.net;

import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;

public class N04Message extends Packet{
	
	private String message;
	private String playerName;
	
	public N04Message(byte[] data)
	{
		super(PacketType.MESSAGE);
		this.setData(data);
	}
	
	public N04Message(String message, String playerName) {
		super(PacketType.MESSAGE);
		// TODO Auto-generated constructor stub
		this.message = message;
		this.playerName = playerName;
		this.setData(this.createData());
	}

	@Override
	protected byte[] createData() {
		String data = message + ":" + playerName;
		return data.getBytes();
	}

	public String getMessage() {
		return message;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
