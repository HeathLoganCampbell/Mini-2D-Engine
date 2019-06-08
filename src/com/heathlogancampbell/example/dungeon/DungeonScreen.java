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
		
		game.map.render(this, game);
	}

}
