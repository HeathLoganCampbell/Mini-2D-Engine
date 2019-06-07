package com.heathlogancampbell.example.dungeon;

import com.heathlogancampbell.miniengine.graphics.Screen;

public class DungeonScreen extends Screen<DungeonGame>
{

	public DungeonScreen(int width, int height) 
	{
		super(width, height);
		
	}
	
	@Override
	public void render(DungeonGame game)
	{
		this.clearScreen();
		
		for(int y = 0; y < 40; y++)
			for(int x = 0; x < 20; x++)
				this.setPixel(x, y, 0xFFFFFF);
	}

}
