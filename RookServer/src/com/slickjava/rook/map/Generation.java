package com.slickjava.rook.map;

import java.util.Random;

import com.slickjava.rook.map.tile.Tile;
import com.slickjava.rook.map.tile.TileManager;

/**
 * Generates map.
 * @author SlickJava
 **/
public class Generation {
	
	public Tile[][] generateMap(int maxX, int maxY)
	{
		Tile[][] map = new Tile[maxY][maxX];
				
		for(int i = 0; i < maxY; i++)
		{
			for(int j = 0; j < maxX; j++)
			{
				Tile randomTile = TileManager.tiles.get(new Random().nextInt(TileManager.tiles.size()));
				for(int k = 0; k < randomTile.getRareness(); k++)
				{
					randomTile = TileManager.tiles.get(new Random().nextInt(TileManager.tiles.size()));
				}
				
				map[i][j] = randomTile;
				map[i][j].setX(j);
				map[i][j].setY(i);
				
			}
		}
		
		return map;
	}

}
