package com.heathlogancampbell.example.dungeon;

import java.util.Random;

import com.heathlogancampbell.example.dungeon.map.Map;
import com.heathlogancampbell.miniengine.Game;
import com.heathlogancampbell.miniengine.inputs.InputListener;

public class DungeonGame extends Game
{
	public Map map;
	
	public DungeonGame()
	{
		this.map = new Map(1);
	}
	
	@Override
	public void tick(InputListener inputListener)
	{	
		
	}
}
