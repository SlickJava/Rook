package com.slickjava.rook.net.packet.packets;

import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;

public class N04Message extends Packet{
	
	private String message;
	private String username;
	
	public N04Message(byte[] data)
	{
		super(PacketType.MESSAGE);
		this.setData(data);
	}
	
	public N04Message(String message, String username) {
		super(PacketType.MESSAGE);
		// TODO Auto-generated constructor stub
		this.message = message;
		this.username = username;
		this.setData(this.createData());
	}

	@Override
	protected byte[] createData() {
		String data = message + ":" + username;
		return data.getBytes();
	}

	public String getMessage() {
		String[] split = this.readData().split(":");
		return split[0];
	}
	
	public String getPlayerName() {
		String[] split = this.readData().split(":");
		return split[1];
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
