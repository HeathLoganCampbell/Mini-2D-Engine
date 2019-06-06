package com.heathlogancampbell.example.snake.player;

import com.heathlogancampbell.example.snake.level.Level;
import com.heathlogancampbell.example.snake.utils.Location;

public class SnakeTail extends Entity
{
	public static final String SNAKE_TAIL_NAME = "Snake Tail";
	
	public SnakeTail(Level level, Location location) 
	{
		super(SNAKE_TAIL_NAME, level, location, Snake.SNAKE_COLOR);
	}
}
