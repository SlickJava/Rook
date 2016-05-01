package com.slickjava.rook.player;

import java.net.InetAddress;

import com.slickjava.rook.player.kingdom.Kingdom;

public class Player {
	
	private String username;
	private Kingdom kingdom;
	private boolean online;
	private InetAddress address;
	
	public Player(String username, InetAddress ip, Kingdom kingdom)
	{
		this.username = username;
		this.kingdom = kingdom;
		this.address = ip;
	}

	public InetAddress getAddress() {
		return address;
	}

	public void setAddress(InetAddress address) {
		this.address = address;
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
