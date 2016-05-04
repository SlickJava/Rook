package com.slickjava.rook.map.tile;

import com.slickjava.rook.player.kingdom.Kingdom;
import com.slickjava.rook.player.kingdom.building.Building;

public abstract class Tile {
	
	private String tileName;
	private Kingdom kingdom;
	private Building building;
	private int rareness;
	private TileAttributes[] attributes;
	private int y;
	private int x;
	
	public Tile(String tileName, TileAttributes[] attributes, int rareness)
	{
		this.tileName = tileName;
		this.attributes = attributes;
		this.rareness = rareness;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}

	public int getRareness() {
		return rareness;
	}

	public void setRareness(int rareness) {
		this.rareness = rareness;
	}
	
	public TileAttributes[] getAttributes() {
		return attributes;
	}

	public void setAttributes(TileAttributes[] attributes) {
		this.attributes = attributes;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public abstract void onFound();
	
	
	public String getTileName() {
		return tileName;
	}

	public void setTileName(String tileName) {
		this.tileName = tileName;
	}

}
