package com.heathlogancampbell.example.snake;

import com.heathlogancampbell.example.snake.utils.Location;
import com.heathlogancampbell.miniengine.graphics.Screen;

public class SnakeScreen extends Screen<SnakeGame> 
{

	public SnakeScreen(int width, int height) 
	{
		super(width, height);
	}

	public void render(SnakeGame game)
	{
		this.clearScreen();
		
		game.level.getEntities().forEach(entity -> {
			Location loc = entity.getLocation();
			this.setPixel(loc.getX(), loc.getY(), entity.getColor());
		});
	}
}
