package com.heathlogancampbell.example.snake.player;

import com.heathlogancampbell.example.snake.utils.Location;

public class Egg extends Entity
{
	public static final String EGG_NAME = "Egg";

	public Egg(Location location) 
	{
		super(EGG_NAME, location);
	}
	
}
