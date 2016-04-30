package com.slickjava.rook;

import com.slickjava.rook.map.Map;
import com.slickjava.rook.map.tile.TileManager;

public class Server {
	
	public static final double ROOK_VERSION = 0.1;
	public static String mapName = "Test";
	public static Map gameMap;
	public static TileManager tileManager;
	
	public static void main(String args[])
	{
		Server server = new Server();
		server.init();
	}
	
	public void init() 
	{
		tileManager = new TileManager();
		//Next two lines are for testing only.
		gameMap = new Map(mapName, 100, 100);
		System.out.println(gameMap.getTileByCoord(5, 78).getTileName());
	}

}
