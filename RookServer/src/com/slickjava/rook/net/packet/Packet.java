package com.slickjava.rook.net.packet;

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
	
	public PacketType getTypeFromData() {
		
		String data = new String(getData());
		for(PacketType type : PacketType.values())
		{
			if(type.getPacketID() == Integer.parseInt(data.substring(0, 2)))
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
