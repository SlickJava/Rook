package com.slickjava.rook.net.packet.packets;

import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;

public class N00Login extends Packet{

	private String username;
	private String password;
	
	public N00Login(byte[] data) {
		super(PacketType.LOGIN);
		this.setData(data);
		// TODO Auto-generated constructor stub
	}
	
	public N00Login(String username, String password) {
		super(PacketType.LOGIN);
		this.username = username;
		this.password = password;
		this.setData(createData());
		// TODO Auto-generated constructor stub
	}
	
	protected byte[] createData()
	{
		String data = this.username + ":" + this.password;
		return data.getBytes();
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
