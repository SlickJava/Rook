package com.slickjava.rook;

import com.slickjava.rook.map.Map;
import com.slickjava.rook.net.MainServer;

public class Server {
	
	public static int port = 4444;
	public static final double ROOK_VERSION = 0.1;
	public static String mapName = "Test";
	public static Map gameMap;
	
	public static void main(String args[])
	{
		Server server = new Server();
		server.init();
	}
	
	public void init() 
	{
		//Next two lines are for testing only.
		gameMap = new Map(mapName, 100, 100);
		MainServer server = new MainServer();
		System.out.println(gameMap.getTileByCoord(5, 78).getTileName());
	}

}
