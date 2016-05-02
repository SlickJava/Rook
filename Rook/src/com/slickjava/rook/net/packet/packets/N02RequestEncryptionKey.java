package com.slickjava.rook.net.packet.packets;

import com.slickjava.rook.net.packet.Packet;
import com.slickjava.rook.net.packet.PacketType;

public class N02RequestEncryptionKey extends Packet{

	public N02RequestEncryptionKey(byte[] data) {
		super(PacketType.REQUEST_ENCRYPTION_KEY);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected byte[] createData() {
		// TODO Auto-generated method stub
		return null;
	}

}
