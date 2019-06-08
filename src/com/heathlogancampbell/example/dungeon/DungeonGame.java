package com.heathlogancampbell.example.dungeon;

import java.util.Random;

import com.heathlogancampbell.example.dungeon.map.Map;
import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class DungeonGame extends Game
{
	public Map map;
	
	public DungeonGame(int width, int height)
	{
		this.map = new Map((int) (Math.random() * 100), width, height);
	}
	
	@Override
	public void tick(InputListener inputListener)
	{	
		
	}
}
