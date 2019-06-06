package com.heathlogancampbell.example.snake.player;

import com.heathlogancampbell.example.snake.level.Level;
import com.heathlogancampbell.example.snake.utils.Location;

public class Entity 
{
	private String name;
	private Location location;
	private Level level;
	private int color;
	
	public Entity(String name, Level level, Location location, int color)
	{
		this.name = name;
		this.level = level;
		this.location = location;
		this.color = color;
	}
	
	public String getName()
	{
		return this.name;
		
	}
	
	public Location getLocation()
	{
		return this.location;
	}
	
	public void setLocation(Location loc)
	{
		this.getLocation().setLocation(loc);
	}
	
	public int getColor()
	{
		return this.color;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
