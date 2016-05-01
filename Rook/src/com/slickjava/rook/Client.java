package com.slickjava.rook;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.slickjava.rook.net.packet.packets.N00Login;
import com.slickjava.rook.net.packet.packets.N01Disconnect;
import com.slickjava.rook.security.Encrypt;

public class Client {
	
	
	public static void main(String args[]) throws IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		
        Encrypt encrypt = new Encrypt();
      
        int counter = 0;
        while(true)
        {
        	counter++;
            N00Login login = new N00Login("SlickJava" + counter, "doge");
            login.sendData(socket, address, 4444, encrypt);
            N01Disconnect disconnect = new N01Disconnect("SlickJava", "doge");
            disconnect.sendData(socket, address, 4444, encrypt);
        }

	}
	
}
