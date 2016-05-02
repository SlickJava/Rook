package com.slickjava.rook;

import com.slickjava.rook.net.MainClient;

public class Client {
	
	private static int port = 4444;
	private static MainClient mainClient;
	
	public static void main(String args[])
	{
		Client client = new Client();
		client.init();
	}
	
	public static int getPort()
	{
		return port;
	}
	
	public void init()
	{
		mainClient = new MainClient("localhost");
	}
	
	public static MainClient getMainClient()
	{
		return mainClient;
	}
	
}
