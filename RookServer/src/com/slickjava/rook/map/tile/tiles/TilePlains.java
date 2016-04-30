package com.slickjava.rook.map.tile.tiles;

import com.slickjava.rook.map.tile.Tile;
import com.slickjava.rook.map.tile.TileAttributes;

public class TilePlains extends Tile{

	public TilePlains() {
		super("Plains", new TileAttributes[] {TileAttributes.HEIGHT_LOW}, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onFound() {
		// TODO Auto-generated method stub
		
	}

}
