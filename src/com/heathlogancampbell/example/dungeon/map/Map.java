package com.heathlogancampbell.example.dungeon.map;

import java.util.ArrayList;
import java.util.Random;

import com.heathlogancampbell.example.dungeon.DungeonGame;
import com.heathlogancampbell.example.dungeon.DungeonScreen;
import com.heathlogancampbell.example.dungeon.map.objects.MapObject;
import com.heathlogancampbell.example.dungeon.map.objects.Room;
import com.heathlogancampbell.miniengine.utils.Renderable;

public class Map implements Renderable<DungeonGame, DungeonScreen>
{
	private int width
			  , height;
	private Random random;
	private ArrayList<MapObject> mapObjects;
	
	public Map(long seed, int width, int height)
	{
		this.random = new Random(seed);
		this.mapObjects = new ArrayList<>();
		
		this.width = width;
		this.height = height;
		generate();
	}
	
	//get closest room
	//get distance
	// move straight up
	// move to the side
	// move direct
	
	public void generate()
	{
		int maxX = 200;
		int maxY = 200;
		
		int maxSizeX = 8;
		int maxSizeY = 6;
		
		int minSizeX = 4;
		int minSizeY = 3;
		
		int lastX = width / 4;
		int lastY = height / 4;
		
		roomSpawnLoop:
		for(int i = 0; i < 5; i++)
		{
			int newX = (this.random.nextInt(maxX) - (maxX / 2)) + lastX;
			int newY = (this.random.nextInt(maxY) - (maxY / 2)) + lastY;
			
			Room room = new Room("Room", newX, newY, (this.random.nextInt(maxSizeX - minSizeX) + minSizeX ) * 10, (this.random.nextInt(maxSizeY - minSizeY) + minSizeY ) * 10);
			for(MapObject mapObject : this.mapObjects)
				if(mapObject instanceof Room)
				{ 
					Room otherRoom = (Room) mapObject;
					if(otherRoom.intersect(room))
					{
						i--;
						continue roomSpawnLoop;
					}
				}
			this.mapObjects.add(room);
		}
	}
	
	
	
	@Override
	public void render(DungeonScreen screen, DungeonGame game) 
	{
		this.mapObjects.forEach(room -> room.render(screen, game));
		
		int width = 9;
		int height = 100;
		for(int x = 0; x < width; x++)
			for(int y = 0; y < height; y++)
			{
				int color = 0xFF00FF;
				if(x <= 2 || x >= width - 3)
					color = 0xEE00EE;
				if(y <= 2 || y >= height - 3)
					color = 0xEE00EE;
				screen.setPixel(x, y, color);
			}
	}

}
