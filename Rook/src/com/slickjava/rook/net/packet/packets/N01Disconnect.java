package com.slickjava.rook.net.packet.packets;

import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;

public class N01Disconnect extends Packet{

	private String username;
	private String password;
	
	public N01Disconnect(byte[] data) {
		super(PacketType.DISCONNECT);
		this.setData(data);
	}
	
	public N01Disconnect(String username, String password) {
		super(PacketType.DISCONNECT);
		this.username = username;
		this.password = password;
		this.setData(this.createData());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected byte[] createData() {
		String sendData = username + ":" + password;
		return sendData.getBytes();
	}
	
	
	public String getUsername()
	{
		String[] split = this.readData().split(":");
		return split[0];
	}
	
	public String getPassword()
	{
		String[] split = this.readData().split(":");
		return split[1];
	}
}
