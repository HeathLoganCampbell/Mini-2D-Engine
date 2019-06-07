package com.heathlogancampbell.example.xor;

import com.heathlogancampbell.miniengine.graphics.Screen;

public class XORScreen extends Screen<XORGame>
{

	public XORScreen(int width, int height) 
	{
		super(width, height);
	}
	
	@Override
	public void render(XORGame game)
	{
		this.clearScreen();
		
		for(int y = 0; y < this.height; y++)
			for(int x = 0; x < this.width; x++)
				this.setPixel(x, y, ((int) (x * game.time)) ^ ((int) (y * game.time)));

	}

}
