package com.slickjava.rook.player.kingdom;

public class Kingdom {
	
	private String name;
	private int baseX;
	private int baseY;
	
	public Kingdom(String name, int baseX, int baseY)
	{
		this.name = name;
		this.baseX = baseX;
		this.baseY = baseY;
		
		this.onCreate();
	}
	
	public void onCreate()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseX() {
		return baseX;
	}

	public void setBaseX(int baseX) {
		this.baseX = baseX;
	}

	public int getBaseY() {
		return baseY;
	}

	public void setBaseY(int baseY) {
		this.baseY = baseY;
	}

}
