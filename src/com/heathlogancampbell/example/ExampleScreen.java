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
		for(int i = 0; i < 360; i++)
		{
			long now = System.currentTimeMillis() + i * 16;
			int x = (int) (Math.sin((now % 3141) / 3141.5 * Math.PI * 2 ) * 40);
			int y = (int) (Math.cos((now % 3141) / 3141.5 * Math.PI * 2) * 40);
			this.setPixel(x + this.width / 2, y + this.height / 2, 0x333333);
		}

	}

}
