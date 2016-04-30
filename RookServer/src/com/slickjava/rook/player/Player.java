package com.slickjava.rook.player;

import com.slickjava.rook.player.kingdom.Kingdom;

public class Player {
	
	private String username;
	private Kingdom kingdom;
	private boolean online;
	
	public Player(String username, Kingdom kingdom)
	{
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

}
