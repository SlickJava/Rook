package com.slickjava.rook;

import com.slickjava.rook.map.Map;
import com.slickjava.rook.map.tile.TileManager;
import com.slickjava.rook.net.MainServer;
import com.slickjava.rook.player.PlayerManager;

public class Server {
	
	public static int port = 4444;
	public static final double ROOK_VERSION = 0.1;
	public static String mapName = "Test";
	public static Map gameMap;
	public static MainServer server;
	public static PlayerManager playerManager;
	
	public static void main(String args[])
	{
		Server server = new Server();
		server.init();
	}
	
	public void init() 
	{
		//Next two lines are for testing only.
		playerManager = new PlayerManager();
		gameMap = new Map(mapName, 100, 100);
		server = new MainServer();
		System.out.println(gameMap.getTileByCoord(5, 78).getTileName());
	}
	
	public static MainServer getMainServer()
	{
		return server;
	}
	
	public static Map getMap()
	{
		return gameMap;
	}

}
