package com.heathlogancampbell.example.snake.player;

import java.awt.event.KeyEvent;

import com.heathlogancampbell.example.snake.utils.Location;
import com.heathlogancampbell.example.snake.utils.Velocity;
import com.heathlogancampbell.miniengine.inputs.InputListener;
import com.heathlogancampbell.miniengine.utils.Tickable;

public class Snake extends Entity implements Tickable
{
	public static final String SNAKE_NAME = "Snake";
	
	private Velocity velocity;

	public Snake(Location location) 
	{
		super(SNAKE_NAME, location);
		
		this.velocity = new Velocity(0, 1);
	}

	@Override
	public void tick(InputListener inputListener)
	{
		
		this.getLocation().addVelocity(velocity);
	}
}
