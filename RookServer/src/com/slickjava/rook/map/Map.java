package com.slickjava.rook.map;

import com.slickjava.rook.map.tile.Tile;
import com.slickjava.rook.map.tile.TileManager;

public class Map {
	
	private String name;
	private Generation mapGen;
	public int maxX;
	public int maxY;
	public Tile[][] map;
	
	public Map(String name, int maxX, int maxY)
	{
		this.addTileTypes();
		mapGen = new Generation();
		this.name = name;
		this.maxX = maxX;
		this.maxY = maxY;
		this.map = mapGen.generateMap(maxX, maxY);
		
	}
	
	public void addTileTypes()
	{
		TileManager tileManager = new TileManager();
	}
	
	public Tile getTileByCoord(int x, int y)
	{
		Tile returnTile = null;
		
		for(int i = 0; i < maxY; i++)
		{
			for(int j = 0; j < maxX; j++)
			{
				if(i == y && j == x)
					returnTile = this.map[i][j];
			}
		}
		
		if(returnTile == null)
			System.out.println("getTileByCoord(" + x + ", " + y + ") is invalid.");
		
		return returnTile;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}

	
}
