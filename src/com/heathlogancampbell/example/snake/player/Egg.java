package com.heathlogancampbell.example.snake.player;

import com.heathlogancampbell.example.snake.level.Level;
import com.heathlogancampbell.example.snake.utils.Location;

public class Egg extends Entity
{
	public static final String EGG_NAME = "Egg";
	public static final int EGG_COLOR = 0x777777;
	

	public Egg(Level level, Location location) 
	{
		super(EGG_NAME, level, location, EGG_COLOR);
	}
	
}
