package com.heathlogancampbell.example;

import com.heathlogancampbell.miniengine.graphics.Screen;

public class ExampleScreen extends Screen<ExampleGame>
{

	public ExampleScreen(int width, int height) 
	{
		super(width, height);
	}
	
	@Override
	public void render(ExampleGame game)
	{
		this.clearScreen();
		
		this.setPixel(game.x, game.y, 0x0ff0ff);
	}

}
