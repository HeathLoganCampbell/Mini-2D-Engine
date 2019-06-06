package com.heathlogancampbell.example.snake.player;

import com.heathlogancampbell.example.snake.level.Level;
import com.heathlogancampbell.example.snake.utils.Location;
import com.heathlogancampbell.miniengine.inputs.InputListener;
import com.heathlogancampbell.miniengine.utils.Tickable;

public class Egg extends Entity implements Tickable
{
	public static final String EGG_NAME = "Egg";
	public static final int EGG_COLOR = 0x777777;
	

	public Egg(Level level, Location location) 
	{
		super(EGG_NAME, level, location, EGG_COLOR);
	}


	@Override
	public void tick(InputListener inputListener) 
	{
		if(this.hasCollision(this.getLevel().getSnake()))
		{
			this.getLevel().eatEgg(this);
		}
	}
	
}
