package com.heathlogancampbell.example.snake;

import com.heathlogancampbell.example.snake.level.Level;
import com.heathlogancampbell.example.snake.player.Snake;
import com.heathlogancampbell.example.snake.utils.Location;
import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class SnakeGame extends Game 
{
	public Level level;
	
	public SnakeGame()
	{
		this.level = new Level(120, 120);
		
		this.level.spawn(new Snake(this.level, new Location(5, 5)));
	}
	
	@Override
	public void tick(InputListener inputListener)
	{
		this.level.tick(inputListener);
	}
}
