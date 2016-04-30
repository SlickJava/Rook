package com.slickjava.rook.map.tile;

import java.util.ArrayList;

import com.slickjava.rook.map.tile.tiles.TilePlains;
import com.slickjava.rook.map.tile.tiles.TileRelic;

public class TileManager {
	
	public static ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public TileManager()
	{
		tiles.add(new TilePlains());
		tiles.add(new TileRelic());
	}

}
