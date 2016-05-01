package com.slickjava.rook;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.slickjava.rook.net.packet.packets.N00Login;
import com.slickjava.rook.security.Encrypt;

public class Client {
	
	
	public static void main(String args[]) throws IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		
        Encrypt encrypt = new Encrypt();
      
        
        N00Login login = new N00Login("SlickJava", "doge");
        login.sendData(socket, address, 4444, encrypt);
        
	}
	
}
