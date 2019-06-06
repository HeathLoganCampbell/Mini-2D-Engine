package com.heathlogancampbell.example.snake;

import com.heathlogancampbell.example.snake.level.Level;
import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class SnakeGame extends Game 
{
	public Level level;
	
	public SnakeGame()
	{
		this.level = new Level(120, 120);
	}
	
	@Override
	public void tick(InputListener inputListener)
	{
		this.level.tick(inputListener);
	}
}
