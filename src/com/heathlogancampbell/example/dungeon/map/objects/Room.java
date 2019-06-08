package com.heathlogancampbell.example.dungeon.map.objects;

import com.heathlogancampbell.example.dungeon.DungeonGame;
import com.heathlogancampbell.example.dungeon.DungeonScreen;
import com.heathlogancampbell.miniengine.utils.Renderable;

public class Room extends MapObject implements Renderable<DungeonGame, DungeonScreen>
{

	public Room(String name, int x, int y, int width, int height)
	{
		super(name, 0xFF00FF, x, y, width, height);
	}
	
	@Override
	public void render(DungeonScreen screen, DungeonGame game)
	{
		for(int y = 0; y < this.getHeight(); y++)
			for(int x = 0; x < this.getWidth(); x++)
			{ 
				screen.setPixel(this.getX() + x, this.getY() + y, this.getColor());
			}
	}
}
