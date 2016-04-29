package com.slickjava.rook.map.tile;

public abstract class Tile {
	
	private String tileName;
	
	public Tile(String tileName)
	{
		this.tileName = tileName;
	}

	public abstract void onFound();
	
	
	public String getTileName() {
		return tileName;
	}

	public void setTileName(String tileName) {
		this.tileName = tileName;
	}

}
