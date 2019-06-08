package com.heathlogancampbell.example.dungeon;

import com.heathlogancampbell.miniengine.Engine;

public class Main {

	public static void main(String[] args) 
	{
		Engine<DungeonGame> engine = new Engine<DungeonGame>(400, 300, 2);
		engine.setScreen(new DungeonScreen(engine.getScreenWidth(), engine.getScreenHeight()));
		engine.setGame(new DungeonGame(engine.getWidth(), engine.getHeight()));
		engine.setTitle("Dungeon Generator");
		engine.start();
	}

}
