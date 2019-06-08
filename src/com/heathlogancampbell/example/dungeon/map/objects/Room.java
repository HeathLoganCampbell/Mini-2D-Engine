package com.heathlogancampbell.example.dungeon.map.objects;

import java.awt.Point;

import com.heathlogancampbell.example.dungeon.DungeonGame;
import com.heathlogancampbell.example.dungeon.DungeonScreen;
import com.heathlogancampbell.miniengine.utils.Renderable;

public class Room extends MapObject implements Renderable<DungeonGame, DungeonScreen>
{
	public Point topRight
			   , bottomLeft;

	public Room(String name, int x, int y, int width, int height)
	{
		super(name, 0xFF00FF, x, y, width, height);
		
		int padding = 1;
		int halfHeight = height / 2;
		int halfWidth = width / 2;
		this.topRight = new Point(x + halfWidth + padding, y + halfHeight + padding);
		this.bottomLeft = new Point(x - halfWidth - padding, y - halfHeight - padding);
	}
	
	
	public boolean intersect(Room other)
	{
		if (this.topRight.getY() <= other.bottomLeft.getY() || this.bottomLeft.getY() >= other.topRight.getY()) {
			return false;
		}
		
		if (this.topRight.getX() <= other.bottomLeft.getX() || this.bottomLeft.getX() >= other.topRight.getX()) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public void render(DungeonScreen screen, DungeonGame game)
	{
		for(int y = 0; y < this.getHeight(); y++)
			for(int x = 0; x < this.getWidth(); x++)
			{ 
				int color = this.getColor();
				
				if(x <= 2 || x >= this.getWidth() - 3)
					color = 0xEE00EE;
				if(y <= 2 || y >= this.getHeight() - 3)
					color = 0xEE00EE;
				
				
				screen.setPixel(this.getX() + x, this.getY() + y, color);
			}
	}
}
