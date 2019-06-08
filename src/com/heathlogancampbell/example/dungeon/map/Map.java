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
	private Random random;
	private ArrayList<MapObject> mapObjects;
	
	public Map(long seed)
	{
		this.random = new Random(seed);
		this.mapObjects = new ArrayList<>();
		
		int maxX = 300;
		int maxY = 300;
		
		int maxSizeX = 40;
		int maxSizeY = 40;
		
		for(int i = 0; i < 10; i++)
		{
			Room room = new Room("Room", this.random.nextInt(maxX), this.random.nextInt(maxY), maxSizeX, maxSizeY);
			this.mapObjects.add(room);
		}
	}
	
	@Override
	public void render(DungeonScreen screen, DungeonGame game) 
	{
		this.mapObjects.forEach(room -> room.render(screen, game));
	}

}
