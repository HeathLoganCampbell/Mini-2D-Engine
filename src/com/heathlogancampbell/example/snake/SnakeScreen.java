package com.heathlogancampbell.example.snake;

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
		
	}
}
