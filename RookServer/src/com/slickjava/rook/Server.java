package com.slickjava.rook;

import com.slickjava.rook.map.Generation;
import com.slickjava.rook.map.tile.TileManager;

public class Server {
	
	public static void main(String args[])
	{
		TileManager tile = new TileManager();
		Generation generation = new Generation();
		generation.generateMap(100, 100);
	}

}
