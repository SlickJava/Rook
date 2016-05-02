package com.slickjava.rook.net.packet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.slickjava.rook.security.Encrypt;

public abstract class Packet {

	protected PacketType type;
	private byte[] data;
	
	public Packet(PacketType type)
	{
		this.type = type;
	}
	
	protected abstract byte[] createData();
	
	public String readData() {
		String changed = new String(data).trim();
		return changed.substring(2);
	}
	
	public byte[] getEncryptedData(Encrypt encrypt) {
		byte[] encrypted = (encrypt.encrypt(new String(this.getSendData())).getBytes());
		return encrypted;
	}
	public byte[] getSendData() {
		
		return this.getData();
	}
	
	public void sendData(DatagramSocket socket, InetAddress address, Encrypt encrypt)
	{
        byte[] encrypted = (encrypt.encrypt(new String(this.getSendData())).getBytes());
		DatagramPacket packet = new DatagramPacket(encrypted,encrypted.length, address, 4444);
		
		try {
			socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static PacketType getTypeFromData(byte[] data) {
		
		String datac = new String(data);
		for(PacketType type : PacketType.values())
		{
			if(type.getPacketID().equals(datac.substring(0, 2)))
			{
				return type;
			}
		}
		return PacketType.INVALID;
	}
	
	private byte[] getData() {
		String withType = type.getPacketID() + new String(data);
		return withType.getBytes();
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
}
