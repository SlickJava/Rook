package com.slickjava.rook.net.packet.packets.net;

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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
