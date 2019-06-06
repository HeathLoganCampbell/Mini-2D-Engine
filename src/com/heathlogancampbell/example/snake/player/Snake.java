package com.heathlogancampbell.example.snake.player;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.heathlogancampbell.example.snake.level.Level;
import com.heathlogancampbell.example.snake.utils.Location;
import com.heathlogancampbell.example.snake.utils.Velocity;
import com.heathlogancampbell.miniengine.inputs.InputListener;
import com.heathlogancampbell.miniengine.utils.Tickable;

public class Snake extends Entity implements Tickable
{
	public static final String SNAKE_NAME = "Snake";
	public static final int SNAKE_COLOR = 0x00FF00;
	
	private Velocity velocity;
	private ArrayList<SnakeTail> snakeTailParts;

	public Snake(Level level, Location location) 
	{
		super(SNAKE_NAME, level, location, SNAKE_COLOR);
		
		this.velocity = new Velocity(0, 1);
		this.snakeTailParts = new ArrayList<>();
		
		for(int i = 0; i < 20; i++)
		{
			Location loc = new Location(0,0);
			loc.setLocation(location);
			SnakeTail snailTail = new SnakeTail(level, loc);
			this.getLevel().spawn(snailTail);
			this.snakeTailParts.add(snailTail);
		}
	}
	
	public ArrayList<SnakeTail> getSnakeTailParts()
	{
		return this.snakeTailParts;
	}

	@Override
	public void tick(InputListener inputListener)
	{
		if(inputListener.isPressed(KeyEvent.VK_D))
		{
			velocity.setX(1);
			velocity.setY(0);
		}
		
		if(inputListener.isPressed(KeyEvent.VK_A))
		{
			velocity.setX(-1);
			velocity.setY(0);
		}
		
		if(inputListener.isPressed(KeyEvent.VK_W))
		{
			velocity.setX(0);
			velocity.setY(-1);
		}
		
		if(inputListener.isPressed(KeyEvent.VK_S))
		{
			velocity.setX(0);
			velocity.setY(1);
		}
		
		for(int i = this.snakeTailParts.size() - 1; i >= 0 ; i--)
		{
			if( i == 0)
				this.snakeTailParts.get(i).setLocation(this.getLocation());
			else 
				this.snakeTailParts.get(i).setLocation(this.snakeTailParts.get(i - 1).getLocation());
		}
		this.getLocation().addVelocity(velocity);
	}
}
