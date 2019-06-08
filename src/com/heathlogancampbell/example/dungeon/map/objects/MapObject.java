package com.heathlogancampbell.example.dungeon.map.objects;

import com.heathlogancampbell.example.dungeon.DungeonGame;
import com.heathlogancampbell.example.dungeon.DungeonScreen;
import com.heathlogancampbell.miniengine.utils.Renderable;

public class MapObject implements Renderable<DungeonGame, DungeonScreen>
{
	private String name;
	private int x, y;
	private int width, height;
	private int color;
	
	public MapObject(String name, int color, int x, int y, int width, int height) 
	{
		this.setName(name);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setColor(color);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
	public void render(DungeonScreen screen, DungeonGame game)
	{
	}
}
