package com.heathlogancampbell.example.snake.player;

import com.heathlogancampbell.example.snake.utils.Location;

public class Entity 
{
	private String name;
	private Location location;
	
	public Entity(String name, Location location)
	{
		this.name = name;
		this.location = location;
	}
	
	public String getName()
	{
		return this.name;
		
	}
	
	public Location getLocation()
	{
		return this.location;
	}
}
